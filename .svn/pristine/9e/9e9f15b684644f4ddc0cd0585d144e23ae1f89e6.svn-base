/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.ProdutoPewag;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DEFRAN-4
 */
public class ExcluirProdutoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            // Obtém o codigo do produto a ser excluído dos parâmetros da solicitação
            String codigo = request.getParameter("inputCodigo");

            // Obtém a fábrica de sessões do Hibernate da classe HibernateUtil
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            // Criação de uma nova sessão do Hibernate
            Session session = sessionFactory.openSession();
            // Iniciando a transação
            Transaction tx = session.beginTransaction();

            try {
                // Verificar se o produto está presente na tabela ProdutosPewag
                String hqlProdPewag = "FROM ProdutoPewag WHERE codigo = :codigo";
                List<ProdutoPewag> produtoPewag = session.createQuery(hqlProdPewag, ProdutoPewag.class)
                        .setParameter("codigo", codigo)
                        .list();

                if (!produtoPewag.isEmpty()) {
                    // Se o codigo do produto está presente na tabela, excluir as informações
                    String hqlExcluirProdPewag = "DELETE FROM ProdutoPewag WHERE codigo = :codigo";
                    session.createQuery(hqlExcluirProdPewag).setParameter("codigo", codigo).executeUpdate();
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
