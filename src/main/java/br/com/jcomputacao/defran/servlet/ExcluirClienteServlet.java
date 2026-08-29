package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.Clientes;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet(name = "ExcluirClienteServlet", urlPatterns = {"/ExcluirClienteServlet"})
public class ExcluirClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            // Obtém a razao do cliente que será excluído dos parâmetros da solicitação
            String razao = request.getParameter("inputRazao");

            // Obtém a fábrica de sessões do Hibernate da classe HibernateUtil
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            // Criação de uma nova sessão do Hibernate
            Session session = sessionFactory.openSession();
            // Iniciando a transação
            Transaction tx = session.beginTransaction();

            try {
                // Verificar se a razao do cliente está presente na tabela
                String hqlClientes = "FROM Clientes WHERE razao = :razao";
                List<Clientes> clientes = session.createQuery(hqlClientes, Clientes.class)
                        .setParameter("razao", razao)
                        .list();

                if (!clientes.isEmpty()) {
                    // Se a razao do cliente está presente na tabela, excluir as informações
                    String hqlExcluirClientes = "DELETE FROM Clientes WHERE razao = :razao";
                    session.createQuery(hqlExcluirClientes).setParameter("razao", razao).executeUpdate();
                    tx.commit();

                    // Responder com um JSON de sucesso
                    out.print("{\"success\": true}");
                } else {
                    // Responder com um JSON indicando falha
                    out.print("{\"success\": false, \"error\": \"Cliente não encontrado.\"}");
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                out.print("{\"success\": false, \"error\":\"Erro ao excluir o cliente do banco de dados.\"}");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            out.print("{\"success\": false, \"error\":\"Erro ao criar a sessão do Hibernate.\"}");
        }
    }
}
