/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.Clientes;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author DEFRAN-4
 */
@WebServlet(name = "BuscaRazaoServlet", urlPatterns = {"/BuscaRazaoServlet"})
public class BuscaRazaoServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            String filtro = request.getParameter("filtro");
            
            // Verificar se o filtro possui pelo menos 3 caracteres para buscar a razão
            if (filtro != null && filtro.length() >= 3) {
                String razaoEncontrada = buscarRazaoNoBancoDeDados(filtro);
                out.print(razaoEncontrada);
            } else {
                // Se o filtro não tiver 3 caracteres, retornar uma mensagem
                out.print("{\"message\":\"Filtro deve conter pelo menos 3 caracteres.\"}");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"error\":\"Erro ao buscar a razão.\"}");
        } finally {
            out.flush();
            out.close();
        }
    }

    // Função para buscar a razão no banco de dados
    private String buscarRazaoNoBancoDeDados(String filtro) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
            Root<Clientes> root = criteriaQuery.from(Clientes.class);

            criteriaQuery.select(root.get("razao"));
            criteriaQuery.where(criteriaBuilder.like(root.get("razao"), filtro + "%"));

            List<String> razoesEncontradas = session.createQuery(criteriaQuery).list();

            if (!razoesEncontradas.isEmpty()) {
                return razoesEncontradas.get(0);
            } else {
                return "Razão não encontrada";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao buscar a razão.";
        }
    }
}