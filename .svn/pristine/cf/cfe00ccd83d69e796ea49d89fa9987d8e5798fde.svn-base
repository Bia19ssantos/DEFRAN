/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.dao.UsuarioDAO;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author DEFRAN-4
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha os parâmetros do formulário
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        // Inicie uma sessão do Hibernate (você deve configurar isso adequadamente)
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(session);

            // Valide as credenciais
            if (usuarioDAO.verificarCredenciais(usuario, senha)) {
                // Credenciais válidas, redirecione para a página index.html
                response.sendRedirect("login.html?sucesso=1");
            } else {
                response.sendRedirect("login.html?erro=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
