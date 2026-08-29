package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.Usuarios;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastroUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha os parâmetros do formulário
        String nome = request.getParameter("inputNome");
        String usuario = request.getParameter("inputUsuario");
        String senha = request.getParameter("inputSenha");
        String confirmarSenha = request.getParameter("inputConfirmarSenha");

        // Validação de Campos
        if (nome == null || nome.isEmpty() || usuario == null || usuario.isEmpty() || senha == null || senha.isEmpty() || confirmarSenha == null || confirmarSenha.isEmpty()) {
            response.sendRedirect("register.html?erro=Preencha todos os campos.");
            return;
        }

        // Verifique o comprimento mínimo da senha
        if (senha.length() < 4) {
            response.sendRedirect("register.html?erro=A senha deve ter pelo menos 4 caracteres.");
            return;
        }

        // Verifique se a senha e a confirmação de senha correspondem
        if (!senha.equals(confirmarSenha)) {
            response.sendRedirect("register.html?erro=As senhas não correspondem.");
            return;
        }

        // Crie uma instância de Usuarios com os dados recebidos
        Usuarios novoUsuario = new Usuarios();
        novoUsuario.setNome(nome);
        novoUsuario.setUser(usuario);
        novoUsuario.setSenha(senha);
        novoUsuario.setRedefinirSenha(senha);
        novoUsuario.setAtivo(true); // Defina como ativo por padrão

        // Inicie uma sessão do Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Inicie uma transação
            transaction = session.beginTransaction();

            // Salve o novo usuário no banco de dados
            session.save(novoUsuario);

            // Faça o commit da transação
            transaction.commit();
        } catch (Exception ex) {
            // Em caso de erro, faça o rollback da transação
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            
            response.sendRedirect("register.html?erro=Erro ao cadastrar o usuário.");
            return;
        } finally {
            // Feche a sessão do Hibernate
            session.close();
        }
            
            response.sendRedirect("registroSucesso.html");
    }
}
