package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.EstoqueGunnebo;
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

public class AtualizarEstoqueGunnServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Parâmetros do formulário
        //int id = Integer.parseInt(request.getParameter("inputId"));
        String codigo = request.getParameter("inputCodigo");
        String referencia = request.getParameter("inputRef");
        double novaQtde = Double.parseDouble(request.getParameter("inputQtde"));

        Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Verifique se já existe um registro com o mesmo código na tabela estoque_gunnebo
            Query<EstoqueGunnebo> query = session.createQuery("FROM EstoqueGunnebo WHERE codigo = :codigo", EstoqueGunnebo.class);
            query.setParameter("codigo", codigo);

            EstoqueGunnebo estoque = query.uniqueResult();

            // Verificar se o produto foi encontrado
            if (estoque != null) {
                // Atualizar a quantidade
                estoque.setQtde(novaQtde);
                
            } else {
                // Criar um novo estoque
                EstoqueGunnebo estoqueGunnebo = criarEstoque(codigo, referencia, novaQtde);
                session.save(estoqueGunnebo);
            }

            // Commit da transação
            transaction.commit();

            // Redirecionar para a página desejada
            response.sendRedirect("est_gunnebo.html");

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

    private EstoqueGunnebo criarEstoque(String codigo, String referencia, double novaQtde) {
        EstoqueGunnebo estoqueGunnebo = new EstoqueGunnebo();
        estoqueGunnebo.setCodigo(codigo);
        estoqueGunnebo.setRefProd(referencia);
        estoqueGunnebo.setQtde(novaQtde);

        return estoqueGunnebo;
    }
}
