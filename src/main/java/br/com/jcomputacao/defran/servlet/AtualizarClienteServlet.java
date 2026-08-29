/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.Clientes;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author DEFRAN-4
 */
public class AtualizarClienteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Parâmetros do formulário
        String razao = request.getParameter("inputRazao");
        String cnpj = request.getParameter("inputCnpj");
        String contato = request.getParameter("inputContato");
        String telefone = request.getParameter("inputTelefone");
        String celular = request.getParameter("inputCelular");
        String email = request.getParameter("inputEmail");

        Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Verifique se já existe um registro com o mesmo código na tabela estoque_defran
            Query query = session.createQuery("FROM Clientes WHERE cnpj = :cnpj");
            query.setParameter("cnpj", cnpj);

            Clientes clientes = (Clientes) query.uniqueResult();

            // Verificar se o produto foi encontrado
            if (clientes != null) {
                // Atualizar os campos
                clientes.setCnpj(cnpj);
                clientes.setRazao(razao);
                clientes.setContato(contato);
                clientes.setTelefone(telefone);
                clientes.setCelular(celular);
                clientes.setEmail(email);

                // Commit da transação
                session.getTransaction().commit();

                // Redirecionar para a página desejada
                response.sendRedirect("clientes.html");
                
            } else {
                
                 out.print("{\"error\":\"CNPJ não encontrado! Faça o cadastro e consulte novamente.\"}");
            }

            // Feche a sessão
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

            // Envie uma resposta JSON de erro
            response.sendRedirect("modalErro.html");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
        
}
