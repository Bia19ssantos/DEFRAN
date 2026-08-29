/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author DEFRAN-4
 */
public class NumOrcExisteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenha o número do orçamento enviado pelo cliente
        String numOrcParam = request.getParameter("numOrc");

        // Configure o tipo de conteúdo da resposta JSON
        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {
            // Verifique se o número do orçamento já existe no banco de dados
            boolean numOrcExistente = verificarNumeroOrcamento(numOrcParam);

            // Envie um JSON indicando se o número do orçamento existe ou não
            out.println("{ \"existe\": " + numOrcExistente + " }");
        } catch (IOException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private boolean verificarNumeroOrcamento(String numOrcParam) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consulta para verificar a existência do número do orçamento (considerando que numOrc é uma string)
            Query query = session.createQuery("SELECT COUNT(*) FROM Orcamento WHERE numOrc = :numOrc");
            query.setParameter("numOrc", numOrcParam);

            // Obtém o resultado da contagem
            Long count = (Long) query.uniqueResult();

            // Se a contagem for maior que zero, o número do orçamento existe
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
