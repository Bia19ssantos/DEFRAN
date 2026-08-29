/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;


import br.com.jcomputacao.defran.model.ProdutoPewag;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
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
public class AtualizarProdutoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Parâmetros do formulário
        String codigo = request.getParameter("inputCodigo");
        String refPewag = request.getParameter("inputRefPewag");
        String refGunnebo = request.getParameter("inputRefGun");
        String descProd = request.getParameter("inputDesc");
        String ncm = request.getParameter("inputNcm");
        double icms = Double.parseDouble(request.getParameter("inputICMS"));
        double ipi = Double.parseDouble(request.getParameter("inputIPI"));
        String tipo = request.getParameter("inputTipo");
        double valorCusto = Double.parseDouble(request.getParameter("inputCusto"));
        double valorVenda = Double.parseDouble(request.getParameter("inputVenda"));
        double compr = Double.parseDouble(request.getParameter("inputCompr"));

        Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Verifique se já existe um registro com o mesmo numOrc na tabela orcamentos
            Query query = session.createQuery("FROM ProdutoPewag WHERE codigo = :codigo");
            query.setParameter("codigo", codigo);

            ProdutoPewag existingProduto = (ProdutoPewag) query.uniqueResult();

            // Verificar se o produto foi encontrado
            if (existingProduto != null) {
                // Atualizar as informações
                existingProduto.setRefGunnebo(refGunnebo);
                existingProduto.setRefPewag(refPewag);
                existingProduto.setIpi(ipi);
                existingProduto.setIcms(icms);
                existingProduto.setValorCusto(valorCusto);
                existingProduto.setValorVenda(valorVenda);

                // Commit da transação
                transaction.commit();

                // Redirecionar para a página desejada
                response.sendRedirect("produtos.html");
            } else {
                // Se não existir cadastro, salvar no banco
                ProdutoPewag novoProduto = novoProduto(codigo, refPewag, refGunnebo, descProd, ncm, icms, ipi, tipo, valorCusto, valorVenda, compr);
                session.save(novoProduto);

                session.flush();

                // Faça o commit da transação
                transaction.commit();

                response.sendRedirect("modalSucesso1.html");
            }

            // Fechar a sessão
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

            // Redirecionar para página de erro
            response.sendRedirect("modalErro.html");
        }
    }

    private ProdutoPewag novoProduto(String codigo, String refPewag, String refGunnebo, String descProd, String ncm, double icms, double ipi, String tipo, double valorCusto, double valorVenda, double compr) {
        ProdutoPewag produtoPewag = new ProdutoPewag();

        produtoPewag.setCodigo(codigo);
        produtoPewag.setRefPewag(refPewag);
        produtoPewag.setRefGunnebo(refGunnebo);
        produtoPewag.setDescProd(descProd);
        produtoPewag.setNcm(ncm);
        produtoPewag.setIcms(icms);
        produtoPewag.setIpi(ipi);
        produtoPewag.setTipo(tipo);
        produtoPewag.setValorCusto(valorCusto);
        produtoPewag.setValorVenda(valorVenda);
        produtoPewag.setComprimento(compr);

        return produtoPewag;
    }
}
