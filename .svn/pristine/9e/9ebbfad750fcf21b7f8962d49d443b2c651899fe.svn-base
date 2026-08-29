/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.OrcLingas;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.math.BigDecimal;
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
@WebServlet(name = "salvarLingaServlet", urlPatterns = {"/salvarLingaServlet"})
public class salvarLingaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configure o tipo de conteúdo da resposta JSON
        response.setContentType("application/json");

        // Obtenha os dados principais do formulário
        String numOrc = request.getParameter("inputNumOrc1");
        String modeloLinga = request.getParameter("inputRefLinga");
        String refItem = request.getParameter("inputRefProd1");
        String qtdeDecimal = request.getParameter("inputQtde1");
        String valorUnitDecimal = request.getParameter("inputValorUnit1");
        String totalItemDecimal = request.getParameter("inputTotalItem1");
        String totalElosInt = request.getParameter("inputTotalElos");
        String totalCorrenteDecimal = request.getParameter("inputTotalCorrente");

        
        // Converta a string totalOrc para um BigDecimal
        BigDecimal qtde = new BigDecimal(qtdeDecimal);
        BigDecimal valorUnit = new BigDecimal(valorUnitDecimal);
        BigDecimal totalItem = new BigDecimal(totalItemDecimal);
        int totalElos = Integer.parseInt(totalElosInt);
        BigDecimal totalCorrente = new BigDecimal(totalCorrenteDecimal);

        Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

                OrcLingas orcLingas = criarOrcLingas(request, numOrc, modeloLinga, refItem, qtde, valorUnit, totalItem, totalElos, totalCorrente);
                session.save(orcLingas);

                // Salve todos os itens do Orcamento no banco de dados
                session.flush();

                // Faça o commit da transação
                transaction.commit();
            
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
    // Método para criar instância de OrcLingas
    private OrcLingas criarOrcLingas(HttpServletRequest request, String numOrc, String modeloLinga, String refItem, BigDecimal qtde, BigDecimal valorUnit, BigDecimal totalItem, int totalElos, BigDecimal totalCorrente) {
  
        // Crie e configure um objeto OrcLingas
        OrcLingas orcLingas = new OrcLingas();
        orcLingas.setNumOrc(numOrc);
        orcLingas.setModeloLinga(modeloLinga);
        orcLingas.setRefAcessorio(refItem);
        orcLingas.setQtdeAcessorio(qtde);
        orcLingas.setValorAcessorio(valorUnit);
        orcLingas.setTotalAcessorio(totalItem);
        orcLingas.setQtdeElos(totalElos);
        orcLingas.setQtdeMetros(totalCorrente);
        return orcLingas;
    }
}
