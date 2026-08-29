/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.OrcLingas;
import br.com.jcomputacao.defran.model.Orcamento;
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

/**
 *
 * @author DEFRAN-4
 */
@WebServlet(name = "ExcluirOrcamentoServlet", urlPatterns = {"/ExcluirOrcamentoServlet"})
public class ExcluirOrcamentoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        
        PrintWriter out = response.getWriter();

        try {
            // Obtém o número do orçamento a ser excluído dos parâmetros da solicitação
            String numOrc = request.getParameter("numOrc");

            // Verificar se o parâmetro numOrcamento foi fornecido
            if (numOrc != null && !numOrc.isEmpty()) {
                // Se o número do orçamento foi fornecido, use-o para excluir o orçamento
                try {
                    
                    excluirOrcamento(out, numOrc);
                } catch (NumberFormatException e) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    out.print("{\"error\":\"Número do orçamento inválido.\"}");
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.print("{\"error\":\"Número do orçamento não fornecido.\"}");
            }
        } finally {
            out.flush();
            out.close();
        }
    }

    private void excluirOrcamento(PrintWriter out, String numOrc) {
        // Obtém a fábrica de sessões do Hibernate da classe HibernateUtil
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Criação de uma nova sessão do Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciando a transação
            Transaction tx = session.beginTransaction();

            try {
                // Excluir os itens associados ao orçamento na tabela ItensOrcamentos
                String hqlItensOrc = "DELETE FROM ItensOrcamentos WHERE numOrc = :numOrc";
                session.createQuery(hqlItensOrc).setParameter("numOrc", numOrc).executeUpdate();

                // Verificar se o número do orçamento está presente na tabela ItensLinga
                String hqlItensLinga = "FROM OrcLingas WHERE numOrc = :numOrc";
                List<OrcLingas> orcLingas = session.createQuery(hqlItensLinga, OrcLingas.class)
                        .setParameter("numOrc", numOrc)
                        .list();

                if (!orcLingas.isEmpty()) {
                    // Se o número do orçamento está presente na tabela ItensLinga, excluir os itens
                    String hqlExcluirItensLinga = "DELETE FROM OrcLingas WHERE numOrc = :numOrc";
                    session.createQuery(hqlExcluirItensLinga).setParameter("numOrc", numOrc).executeUpdate();
                }

                // Verificar se o número do orçamento está presente na tabela Orcamento
                String hqlOrcamento = "FROM Orcamento WHERE numOrc = :numOrc";
                List<Orcamento> orcamentos = session.createQuery(hqlOrcamento, Orcamento.class)
                        .setParameter("numOrc", numOrc)
                        .list();

                if (!orcamentos.isEmpty()) {
                    // Se o número do orçamento está presente na tabela Orcamento, excluir o orçamento
                    String hqlExcluirOrcamento = "DELETE FROM Orcamento WHERE numOrc = :numOrc";
                    int rowsAffected = session.createQuery(hqlExcluirOrcamento).setParameter("numOrc", numOrc).executeUpdate();

                    tx.commit();

                    if (rowsAffected > 0) {
                        out.print("{\"success\":\"Orçamento e itens associados excluídos com sucesso.\"}");
                    } else {
                        out.print("{\"error\":\"Orçamento não encontrado.\"}");
                    }
                } else {
                    out.print("{\"error\":\"Número do orçamento não encontrado na tabela Orcamento.\"}");
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                out.print("{\"error\":\"Erro ao excluir o orçamento e itens do banco de dados.\"}");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            out.print("{\"error\":\"Erro ao criar a sessão do Hibernate.\"}");
        }
    }
}
