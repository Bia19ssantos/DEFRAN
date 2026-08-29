package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.ProdutoSpanset;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@WebServlet(name = "ProdSpansetServlet", urlPatterns = {"/ProdSpansetServlet"})
public class ProdSpansetServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            // Obtém a fábrica de sessões do Hibernate da classe HibernateUtil
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            // Criação de uma nova sessão do Hibernate
            try (Session session = sessionFactory.openSession()) {
                // Iniciando a transação (opcional, dependendo do caso)
                Transaction tx = session.beginTransaction();

                // Execução da consulta usando HQL (Hibernate Query Language)
                String hql = "FROM ProdutoSpanset";
                List<ProdutoSpanset> produtosSpanset = session.createQuery(hql, ProdutoSpanset.class).list();

                // Commit da transação (opcional, dependendo do caso)
                tx.commit();

                // Converter a lista de produtos em JSON usando o Gson
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(produtosSpanset);

                // Enviar a resposta JSON para a solicitação AJAX
                out.print(json);
            } catch (Exception ex) {
                ex.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.print("{\"error\":\"Erro ao obter os dados do banco de dados.\"}");
            }
        } finally {
            out.flush();
            out.close();
        }
    }
}
