/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.Vendas;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
@WebServlet(name = "VendasServlet", urlPatterns = {"/VendasServlet"})
public class VendasServlet extends HttpServlet {
    
   private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            // Obtém o número do orçamento a partir dos parâmetros da solicitação
            String numPedido = request.getParameter("numPedido");
            
            // Verificar se o parâmetro numOrcamento foi fornecido
            if (numPedido != null && !numPedido.isEmpty()) {
                // Se o número do orçamento foi fornecido, use-o para filtrar os resultados
                try {
                   
                    filtrarPorNumPedido(out, numPedido);
                } catch (NumberFormatException e) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    out.print("{\"error\":\"Número do Pedido inválido.\"}");
                }
            } else {
               out.print("{\"error\":\"Número do Pedido não encontrado.\"}");
            }
        } finally {
            out.flush();
            out.close();
        }
    }

    private void filtrarPorNumPedido(PrintWriter out, String numPedido) {
        // Obtém a fábrica de sessões do Hibernate da classe HibernateUtil
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Criação de uma nova sessão do Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciando a transação (opcional, dependendo do caso)
            Transaction tx = session.beginTransaction();

            // Execução da consulta usando HQL (Hibernate Query Language)
            String hql = "FROM Vendas WHERE numPedido = :numPedido";
            List<Vendas> vendas = session.createQuery(hql, Vendas.class)
                    .setParameter("numPedido", numPedido)
                    .list();

            // Commit da transação (opcional, dependendo do caso)
            tx.commit();

            // Converter a lista de produtos em JSON usando o Gson
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(vendas);

            // Enviar a resposta JSON para a solicitação AJAX
            out.print(json);
        } catch (Exception ex) {
            ex.printStackTrace();
            out.print("{\"error\":\"Erro ao obter os dados do banco de dados.\"}");
        }
    }
}