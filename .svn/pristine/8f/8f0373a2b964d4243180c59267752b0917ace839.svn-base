/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *mvn exec:java
 * @author DEFRAN-4
 */

package br.com.jcomputacao.defran.resources;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Carregar as configurações do arquivo personalizado (neste exemplo, hibernate-config.xml)
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

            // Criar a fábrica de sessões do Hibernate
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Falha ao inicializar a fábrica de sessões do Hibernate: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
