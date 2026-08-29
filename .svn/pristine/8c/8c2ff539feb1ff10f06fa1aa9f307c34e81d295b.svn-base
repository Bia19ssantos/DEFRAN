/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.ItensPedido;
import br.com.jcomputacao.defran.model.Vendas;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "SalvarVendaServlet", urlPatterns = {"/SalvarVendaServlet"})
public class SalvarVendaServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configure o tipo de conteúdo da resposta JSON
        response.setContentType("application/json");

        // Obtenha os dados principais do formulário
        String numPedido = request.getParameter("inputNumPedido");
        String numOrc = request.getParameter("inputNumOrc");
        String dataPedidoString = request.getParameter("inputDataPedido");
        String cliente = request.getParameter("inputCliente");
        String dataNFString = request.getParameter("inputDataNF");
        String numNF = request.getParameter("inputNF");
        String totalPedidoDecimal = request.getParameter("inputTotalPedido");

        // Converta a string totalOrc para um BigDecimal
        BigDecimal totalPedido = new BigDecimal(totalPedidoDecimal);

        Date dataPedido = null;
        if (dataPedidoString == null || dataPedidoString.isEmpty()) {
            dataPedido = new Date();
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dataPedido = dateFormat.parse(dataPedidoString);
            } catch (ParseException ex) {
                Logger.getLogger(OrcSalvarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
           Date dataNF = null;
        if (dataNFString == null || dataNFString.isEmpty()) {
            dataNF = new Date();
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dataNF = dateFormat.parse(dataNFString);
            } catch (ParseException ex) {
                Logger.getLogger(OrcSalvarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Obtenha os dados principais do formulário
        String itemString = request.getParameter("inputItem");
        String refItem = request.getParameter("inputRefItem");
        String ncm = request.getParameter("inputNcm");
        String tipo = request.getParameter("inputTipo");
        String qtdeDecimal = request.getParameter("inputQtde");
        String valorUnitDecimal = request.getParameter("inputValorUnit");
        String totalItemDecimal = request.getParameter("inputTotalItem");

        int item = Integer.parseInt(itemString);

        // Converta a string totalOrc para um BigDecimal
        BigDecimal qtde = new BigDecimal(qtdeDecimal);
        BigDecimal valorUnit = new BigDecimal(valorUnitDecimal);
        BigDecimal totalItem = new BigDecimal(totalItemDecimal);
        
         Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            // Verifique se já existe um registro com o mesmo numOrc na tabela orcamentos
            Query query = session.createQuery("FROM Vendas WHERE numPedido = :numPedido");
            query.setParameter("numPedido", numPedido);

            Vendas existingVendas = (Vendas) query.uniqueResult();

            if (existingVendas == null) {
           
            // Se não existir, então salve o novo Orcamento no banco de dados
            Vendas vendas = criarVenda(request, numPedido, numOrc, dataPedido, cliente, dataNF, numNF, totalPedido);
            session.save(vendas);

            ItensPedido itensPedido = criarItensPedido(request, numPedido, item, refItem, ncm, tipo, qtde, valorUnit, totalItem);
                session.save(itensPedido);

                // Salve todos os itens do Orcamento no banco de dados
                session.flush();

                // Faça o commit da transação
                transaction.commit();

                // Envie uma resposta JSON de sucesso
                //response.setStatus(HttpServletResponse.SC_OK);
                //response.sendRedirect("modalConfirmacao.html");
            } else {
               ItensPedido itensPedido = criarItensPedido(request, numPedido, item, refItem, ncm, tipo, qtde, valorUnit, totalItem);
                session.save(itensPedido);
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
        
    // Método para criar instância de Vendas
    private Vendas criarVenda(HttpServletRequest request, String numPedido, String numOrc, Date dataPedido, String cliente, Date dataNF, String numNF, BigDecimal totalPedido) {
        Vendas vendas = new Vendas();
        
        vendas.setNumPedido(numPedido);
        vendas.setNumOrc(numOrc);
        vendas.setDataPedido(dataPedido);
        vendas.setCliente(cliente);
        vendas.setDataNF(dataNF);
        vendas.setNumNF(numNF);
        vendas.setTotalPedido(totalPedido);
        return vendas;
    }
    
        // Método para criar instância de Pedido
    private ItensPedido criarItensPedido(HttpServletRequest request, String numPedido, int item, String refItem, String ncm, String tipo, BigDecimal qtde, BigDecimal valorUnit, BigDecimal totalItem) {
        ItensPedido itensPedido = new ItensPedido();
        
        itensPedido.setNumPedido(numPedido);
        itensPedido.setItem(item);
        itensPedido.setRefItem(refItem);
        itensPedido.setNcm(ncm);
        itensPedido.setTipo(tipo);
        itensPedido.setQtdeItem(qtde);
        itensPedido.setValorUnit(valorUnit);
        itensPedido.setTotalItem(totalItem);
        return itensPedido;
    }

   
}
