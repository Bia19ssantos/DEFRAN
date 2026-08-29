/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import br.com.jcomputacao.defran.model.Orcamento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        Configuration configuration = new Configuration();
        configuration.configure(); 

        // Construir a fábrica de sessões
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Abrir uma sessão do Hibernate
        Session session = sessionFactory.openSession();

        try {
            // Iniciar uma transação
            Transaction transaction = session.beginTransaction();

            // Consultar todos os objetos Orcamento usando HQL
            List<Orcamento> orcamentos = session.createQuery("FROM Orcamento", Orcamento.class).list();

            // Iterar sobre os resultados
            for (Orcamento orcamento : orcamentos) {
                System.out.println(orcamento.toString());
                //System.out.println(orcamento.itensToString());
            }

            // Commit da transação
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar a sessão do Hibernate
            session.close();
        }

        // Fechar a fábrica de sessões do Hibernate
        sessionFactory.close();
    }
}

