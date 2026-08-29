
import br.com.jcomputacao.defran.model.Orcamento;
import br.com.jcomputacao.defran.model.ItensOrcamentos;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet(name = "TesteInsercaoServlet", urlPatterns = {"/TesteInsercaoServlet"})
public class TesteInsercaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            String tipo = request.getParameter("tipo");

            if ("orcamento".equals(tipo)) {
                // Processar os dados do formulário principal (orcamento) e salvar no banco
                Orcamento orcamento = new Orcamento();
                // Mapear os campos do formulário para os campos da entidade Orcamento
                //orcamento.setNumOrc(request.getParameter("numOrc"));
                orcamento.setDataOrc(new Date());
                orcamento.setVendedor(request.getParameter("vendedor"));
                orcamento.setCliente(request.getParameter("cliente"));
                orcamento.setCnpj(request.getParameter("cnpj"));
                orcamento.setContato(request.getParameter("contato"));
                orcamento.setCondicaoPgto(request.getParameter("condPgto"));
                orcamento.setCondicaoTransporte(request.getParameter("condTransporte"));
                

                // Obtém a fábrica de sessões do Hibernate
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

                try (Session session = sessionFactory.openSession()) {
                    Transaction tx = session.beginTransaction();

                    // Salvar o Orcamento no banco de dados
                    session.save(orcamento);

                    // Agora, você pode criar itens do orçamento relacionados a este orçamento
                    String[] numOrcs = request.getParameterValues("itens[numOrc][]");

                    for (String numOrcItem : numOrcs) {
                        ItensOrcamentos itemOrcamento = new ItensOrcamentos();
                        itemOrcamento.setRefProd(request.getParameter("itens[refProd][" + numOrcItem + "]"));
                        itemOrcamento.setItem(Integer.parseInt(request.getParameter("itens[item][" + numOrcItem + "]")));
                        itemOrcamento.setNcm(request.getParameter("itens[ncm][" + numOrcItem + "]"));
                        itemOrcamento.setTipo(request.getParameter("itens[tipo][" + numOrcItem + "]"));
                        itemOrcamento.setDescProd(request.getParameter("itens[descProd][" + numOrcItem + "]"));
                        
                        itemOrcamento.setPrazoEntrega(request.getParameter("itens[prazoEntrega][" + numOrcItem + "]"));

                        // Salvar o item do Orcamento no banco de dados
                        session.save(itemOrcamento);
                    }

                    tx.commit();

                    out.println("{\"sucesso\": true}");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    out.println("{\"sucesso\": false, \"mensagem\": \"Erro ao inserir Orcamento no banco de dados.\"}");
                }
            } else {
                // Tipo de dados desconhecido, lidar com erro
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("{\"sucesso\": false, \"mensagem\": \"Tipo de dados desconhecido.\"}");
            }
        } finally {
            out.flush();
            out.close();
        }
    }
}
