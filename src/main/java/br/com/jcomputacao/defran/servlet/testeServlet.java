/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.ItensOrcamentos;
import br.com.jcomputacao.defran.model.Orcamento;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "testeServlet", urlPatterns = {"/testeServlet"})
public class testeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenha os dados principais do formulário
        String numOrc = request.getParameter("inputNumOrc");
        String dataOrcString = request.getParameter("inputDataOrc");
        String vendedor = request.getParameter("inputVendedor");
        String cnpj = request.getParameter("inputCnpj");
        String cliente = request.getParameter("inputCliente");
        String contato = request.getParameter("inputContato");
        String condPgto = request.getParameter("inputPagamento");
        String condTransporte = request.getParameter("inputTransporte");
        String totalOrc = request.getParameter("inputTotalOrc");

        // Converta a string totalOrc para um BigDecimal
        BigDecimal totalOrcDecimal = new BigDecimal(totalOrc);

        Date dataOrc = null;
        if (dataOrcString == null || dataOrcString.isEmpty()) {
            dataOrc = new Date();
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dataOrc = dateFormat.parse(dataOrcString);
            } catch (ParseException ex) {
                Logger.getLogger(testeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Orcamento orcamento = criarOrcamento(request, numOrc, dataOrc, vendedor, cnpj, cliente, contato, condPgto, condTransporte, totalOrcDecimal);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Inicie uma transação
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Salve o Orcamento no banco de dados
            session.save(orcamento);

            // Analise os dados da tabela
            for (int i = 1;; i++) {
                String linhaData = request.getParameter("linha" + i);

                if (linhaData == null) {
                    // Não há mais dados para processar
                    break;
                }

                // Separe os valores dos campos usando a vírgula como separador
                String[] valores = linhaData.split(",");

                if (valores.length == 9) { // Certifique-se de que há 9 valores
                    // Extraia os valores dos campos
                    String item = valores[0];
                    String referencia = valores[1];
                    String descricao = valores[2];
                    String ncm = valores[3];
                    String tipo = valores[4];
                    String qtde = valores[5];
                    String valorUnitario = valores[6];
                    String totalItem = valores[7];
                    String prazoEntrega = valores[8];

                    // Converta a string para Int e BigDecimal
                    Integer itemInt = new Integer(item);
                    BigDecimal qtdeDecimal = new BigDecimal(qtde);
                    BigDecimal valorUnitarioDecimal = new BigDecimal(valorUnitario);
                    BigDecimal totalItemDecimal = new BigDecimal(totalItem);

                    // Crie uma instância de ItensOrcamentos
                    ItensOrcamentos itens = new ItensOrcamentos();
                    itens.setItem(itemInt);
                    itens.setRefProd(referencia);
                    itens.setDescProd(descricao);
                    itens.setNcm(ncm);
                    itens.setTipo(tipo);
                    itens.setQtde(qtdeDecimal);
                    itens.setValorUnit(valorUnitarioDecimal);
                    itens.setTotalItem(totalItemDecimal);
                    itens.setPrazoEntrega(prazoEntrega);
                    //itens.setOrcamento(orcamento);

                    // Salve os ItensOrcamentos no banco de dados
                    session.save(itens);
                }
            }

            // Faça o commit da transação
            transaction.commit();

            // Feche a sessão
            session.close();

            // Responda com sucesso
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            // Em caso de erro, faça o rollback da transação e lide com o erro
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            // Você pode redirecionar para uma página de erro ou retornar uma mensagem de erro
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            // Certifique-se de fechar a sessão em caso de exceção
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    // Métodos para criar instâncias de Orcamento e ItensOrcamentos
    private Orcamento criarOrcamento(HttpServletRequest request, String numOrc, Date dataOrc, String vendedor, String cnpj, String cliente, String contato, String condPgto, String condTransporte, BigDecimal totalOrc) {
        Orcamento orcamento = new Orcamento();
        orcamento.setNumOrc(numOrc);
        orcamento.setDataOrc(dataOrc);
        orcamento.setVendedor(vendedor);
        orcamento.setCnpj(cnpj);
        orcamento.setCliente(cliente);
        orcamento.setContato(contato);
        orcamento.setCondicaoPgto(condPgto);
        orcamento.setCondicaoTransporte(condTransporte);
        orcamento.setTotalOrc(totalOrc);
        return orcamento;
    }
}
