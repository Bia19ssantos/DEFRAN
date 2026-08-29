package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.OrcLingas;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet(name = "lingasServlet", urlPatterns = {"/lingasServlet"})
public class lingasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configure o tipo de conteúdo da resposta JSON
        response.setContentType("application/json");

        Transaction transaction = null;

        try {
            
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Recupere os valores dos campos ocultos
            String[] numOrcs = request.getParameterValues("numOrc[]");
            String[] modLinga = request.getParameterValues("modLinga[]");
            String[] refItems = request.getParameterValues("refItem[]");
            String[] quantidades = request.getParameterValues("quantidade1[]");
            String[] valoresUnitarios = request.getParameterValues("valorUnitario[]");
            String[] totalItens = request.getParameterValues("totalItem[]");

            // Valide os dados dos acessorios antes de processá-los
            if (numOrcs != null && numOrcs.length > 0) {
                List<OrcLingas> itensList = new ArrayList<>(); // Crie uma lista para armazenar os itens

                for (int i = 0; i < numOrcs.length; i++) {
                    String numOrc = numOrcs[i];
                    String modeloLinga = modLinga[i];
                    String refItem = refItems[i];
                    String quantidade = quantidades[i];
                    String valorUnitario = valoresUnitarios[i];
                    String totalItem = totalItens[i];
                    // Obtenha os dados principais do formulário
                    String totalCorrente = request.getParameter("inputTotalCorrente");
                    String totalElos = request.getParameter("inputTotalElos");

                    // Verifique se os valores não estão vazios ou nulos
                    if (numOrc != null && modeloLinga != null && refItem != null
                            && quantidade != null && valorUnitario != null && totalItem != null && totalElos != null && totalCorrente != null) {

                        BigDecimal quantidadeDecimal = new BigDecimal(quantidade);
                        BigDecimal valorUnitarioDecimal = new BigDecimal(valorUnitario);
                        BigDecimal totalItemDecimal = new BigDecimal(totalItem);
                        Integer totalElosInt = Integer.parseInt(totalElos);
                        BigDecimal totalCorrenteDecimal = new BigDecimal(totalCorrente);
                        
                        // Crie e configure um objeto ItensOrcamentos
                        OrcLingas orcLingas = new OrcLingas();
                        orcLingas.setNumOrc(numOrc);
                        orcLingas.setModeloLinga(modeloLinga);
                        orcLingas.setRefAcessorio(refItem);
                        orcLingas.setQtdeAcessorio(quantidadeDecimal);
                        orcLingas.setValorAcessorio(valorUnitarioDecimal);
                        orcLingas.setTotalAcessorio(totalItemDecimal);
                        orcLingas.setQtdeElos(totalElosInt);
                        orcLingas.setQtdeMetros(totalCorrenteDecimal);

                        // Adicione o objeto à lista
                        itensList.add(orcLingas);
                    }
                }
                // Salve todos os itens do Orcamento no banco de dados
                for (OrcLingas orcLingas : itensList) {
                    session.save(orcLingas);
                }
            }

            // Salve todos os itens do Orcamento no banco de dados
            session.flush();

            // Faça o commit da transação
            transaction.commit();

            // Feche a sessão
            session.close();

            // Envie uma resposta JSON de sucesso
            response.setStatus(HttpServletResponse.SC_OK);

            response.sendRedirect("modalConfirmacao.html");

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

}
