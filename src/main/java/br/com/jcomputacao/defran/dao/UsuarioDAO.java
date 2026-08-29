/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.dao;

import br.com.jcomputacao.defran.model.Usuarios;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author DEFRAN-4
 */


public class UsuarioDAO {
    private Session session;

    public UsuarioDAO(Session session) {
        this.session = session;
    }

    public boolean verificarCredenciais(String usuario, String senha) {
        try {
            Query<Usuarios> query = session.createQuery(
                "FROM Usuarios WHERE usuario = :usuario AND senha = :senha",
                Usuarios.class
            );
            query.setParameter("usuario", usuario);
            query.setParameter("senha", senha);

            Usuarios usuarioEncontrado = query.uniqueResult();
            
            return usuarioEncontrado != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}