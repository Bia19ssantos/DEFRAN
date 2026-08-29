package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.ItensOrcamentos;
import br.com.jcomputacao.defran.model.Orcamento;
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

@WebServlet(name = "OrcSalvarServlet", urlPatterns = {"/OrcSalvarServlet"})
public class OrcSalvarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configure o tipo de conteúdo da resposta JSON
        response.setContentType("application/json");

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
                Logger.getLogger(OrcSalvarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Obtenha os dados principais do formulário
        String itemString = request.getParameter("inputItem");
        String refProd = request.getParameter("inputRefProd");
        String descProd = request.getParameter("inputDescProd");
        String ncm = request.getParameter("inputNcm");
        String tipo = request.getParameter("inputTipo");
        String qtdeDecimal = request.getParameter("inputQtde");
        String valorUnitDecimal = request.getParameter("inputValorUnit");
        String totalItemDecimal = request.getParameter("inputTotalItem");
        String prazoEntrega = request.getParameter("inputPrazoEntrega");

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
            Query query = session.createQuery("FROM Orcamento WHERE numOrc = :numOrc");
            query.setParameter("numOrc", numOrc);

            Orcamento existingOrcamento = (Orcamento) query.uniqueResult();

            if (existingOrcamento == null) {
                // Se não existir, então salve o novo Orcamento no banco de dados
                Orcamento orcamento = criarOrcamento(request, numOrc, dataOrc, vendedor, cnpj, cliente, contato, condPgto, condTransporte, totalOrcDecimal);
                session.save(orcamento);

                ItensOrcamentos itensOrcamentos = criarItensOrcamento(request, numOrc, item, refProd, descProd, ncm, tipo, qtde, valorUnit, totalItem, prazoEntrega);
                session.save(itensOrcamentos);

                // Salve todos os itens do Orcamento no banco de dados
                session.flush();

                // Faça o commit da transação
                transaction.commit();

            } else {
                ItensOrcamentos itensOrcamentos = criarItensOrcamento(request, numOrc, item, refProd, descProd, ncm, tipo, qtde, valorUnit, totalItem, prazoEntrega);
                session.save(itensOrcamentos);
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
    // Método para criar instância de Orcamento

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

    // Método para criar instância de Orcamento
    private ItensOrcamentos criarItensOrcamento(HttpServletRequest request, String numOrc, int item, String refProd, String descProd, String ncm, String tipo, BigDecimal qtde, BigDecimal valorUnit, BigDecimal totalItem, String prazoEntrega) {
        ItensOrcamentos itensOrcamentos = new ItensOrcamentos();
        itensOrcamentos.setNumOrc(numOrc);
        itensOrcamentos.setItem(item);
        itensOrcamentos.setRefProd(refProd);
        itensOrcamentos.setDescProd(descProd);
        itensOrcamentos.setNcm(ncm);
        itensOrcamentos.setTipo(tipo);
        itensOrcamentos.setQtde(qtde);
        itensOrcamentos.setValorUnit(valorUnit);
        itensOrcamentos.setTotalItem(totalItem);
        itensOrcamentos.setPrazoEntrega(prazoEntrega);
        return itensOrcamentos;
    }
}
