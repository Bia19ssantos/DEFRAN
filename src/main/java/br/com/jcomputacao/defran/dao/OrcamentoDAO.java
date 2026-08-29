/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.dao;

/**
 *
 * @author DEFRAN-4
 */

import br.com.jcomputacao.defran.model.Orcamento;
import org.hibernate.Session;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrcamentoDAO {

    private SessionFactory sessionFactory;

    public OrcamentoDAO() {
        // Configure a fábrica de sessões do Hibernate
        Configuration configuration = new Configuration();
        configuration.configure(); // Use o arquivo hibernate.cfg.xml para configurações
        sessionFactory = configuration.buildSessionFactory();
    }

    public List<Orcamento> getOrcamentos() {
        try (Session session = sessionFactory.openSession()) {
            // Inicie uma transação
            session.beginTransaction();

            // Consulte todos os objetos Orcamento
            List<Orcamento> orcamentos = session.createQuery("FROM Orcamento", Orcamento.class).list();

            // Comita a transação
            session.getTransaction().commit();

            return orcamentos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        // Feche a fábrica de sessões quando não precisar mais
        sessionFactory.close();
    }

}