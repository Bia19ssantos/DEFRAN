/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.Vendas;
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
public class ExcluirVendasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        // Obtém o número do Pedido a ser excluído dos parâmetros da solicitação
        String numPedido = request.getParameter("numPedido");

        excluirPedido(out, numPedido);

    }

    private void excluirPedido(PrintWriter out, String numPedido) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            try {
                String hqlItensPedidos = "DELETE FROM ItensPedido WHERE numPedido = :numPedido";
                session.createQuery(hqlItensPedidos).setParameter("numPedido", numPedido).executeUpdate();

                String hqlVendas = "FROM Vendas WHERE numPedido = :numPedido";
                List<Vendas> vendas = session.createQuery(hqlVendas, Vendas.class)
                        .setParameter("numPedido", numPedido)
                        .list();

                if (!vendas.isEmpty()) {
                    String hqlExcluirPedido = "DELETE FROM Vendas WHERE numPedido = :numPedido";
                    int rowsAffected = session.createQuery(hqlExcluirPedido)
                            .setParameter("numPedido", numPedido)
                            .executeUpdate();

                    if (rowsAffected > 0) {
                        out.print("{\"success\":\"Pedido e itens associados excluídos com sucesso.\"}");
                    } else {
                        out.print("{\"error\":\"Pedido não encontrado.\"}");
                    }
                } else {
                    out.print("{\"error\":\"Número do Pedido não encontrado na tabela de Vendas.\"}");
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                out.print("{\"error\":\"Erro ao excluir o pedido e itens do banco de dados.\"}");
            } finally {
                tx.commit(); // Mova o commit para o bloco finally para garantir que seja chamado mesmo em caso de exceção
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            out.print("{\"error\":\"Erro ao criar a sessão do Hibernate.\"}");
        }
    }
}
