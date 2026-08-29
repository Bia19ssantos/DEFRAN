/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.EstoqueDefran;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "AtualizarEstoqueServlet", urlPatterns = {"/AtualizarEstoqueServlet"})
public class AtualizarEstoqueServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Parâmetros do formulário
        int id = Integer.parseInt(request.getParameter("inputId"));
        String codigo = request.getParameter("inputCodigo");
        String referencia = request.getParameter("inputRef");
        String descricao = request.getParameter("inputDescricao");
        double novaQtde = Double.parseDouble(request.getParameter("inputQtde"));

        Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Verifique se já existe um registro com o mesmo código na tabela estoque_defran
            Query query = session.createQuery("FROM EstoqueDefran WHERE codigo = :codigo");
            query.setParameter("codigo", codigo);

            EstoqueDefran estoque = (EstoqueDefran) query.uniqueResult();

            // Verificar se o produto foi encontrado
            if (estoque != null) {
                // Atualizar a quantidade
                estoque.setQtde(novaQtde);

                // Commit da transação
                session.getTransaction().commit();

                // Redirecionar para a página desejada
                response.sendRedirect("estoque.html");
            } else {
                EstoqueDefran estoqueDefran = criarEstoque(request, id, codigo, referencia, descricao, novaQtde);
                session.save(estoqueDefran);
                
               response.sendRedirect("modalSucesso1.html");
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
        private EstoqueDefran criarEstoque(HttpServletRequest request, int id, String codigo, String referencia, String descricao, double qtde) {
        EstoqueDefran estoqueDefran = new EstoqueDefran();
        estoqueDefran.setId(id);
        estoqueDefran.setCodigo(codigo);
        estoqueDefran.setRefProd(referencia);
        estoqueDefran.setDescProd(descricao);
        estoqueDefran.setQtde(qtde);
        
        return estoqueDefran;
    }
        
}
