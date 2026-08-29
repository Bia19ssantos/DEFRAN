package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.Clientes;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet(name = "SalvarClienteServlet", urlPatterns = {"/SalvarClienteServlet"})
public class SalvarClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            
            // Coletar os dados do formulário
            String razao = request.getParameter("razao");
            String cnpj = request.getParameter("cnpj");
            String contato = request.getParameter("contato");
            String telefone = request.getParameter("telefone");
            String celular = request.getParameter("celular");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String email = request.getParameter("email");
            String condPgto = request.getParameter("condPgto");
            String condTransporte = request.getParameter("condTransporte");
            String cep = request.getParameter("cep");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String bairro = request.getParameter("bairro");
            String endereco = request.getParameter("endereco");

            // Criar um objeto da classe Teste
            Clientes cliente = new Clientes();
            cliente.setRazao(razao);
            cliente.setCnpj(cnpj);
            cliente.setContato(contato);
            cliente.setTelefone(telefone);
            cliente.setCelular(celular);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);
            cliente.setEmail(email);
            cliente.setCondPgto(condPgto);
            cliente.setCondTransporte(condTransporte);
            cliente.setCep(cep);
            cliente.setNumero(numero);
            cliente.setComplemento(complemento);
            cliente.setBairro(bairro);
            cliente.setLogradouro(endereco);

            // Salvar o objeto no banco de dados usando o Hibernate
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();
                session.save(cliente);
                transaction.commit();

                // Resposta JSON de sucesso
                Gson gson = new Gson();
                String json = gson.toJson("Os dados foram salvos com sucesso.");
                out.println(json);
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();

                // Resposta JSON de erro
                Gson gson = new Gson();
                String json = gson.toJson("Erro ao salvar os dados no banco de dados.");
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.println(json);

            } finally {
                session.close();
            }

        }
    }
}
