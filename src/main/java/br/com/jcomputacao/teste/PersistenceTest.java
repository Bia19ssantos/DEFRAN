package br.com.jcomputacao.teste;

import br.com.jcomputacao.defran.model.ProdutoGunnebo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import java.util.List;

public class PersistenceTest {

    @Test
    public void testPersistence() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DEFRAN");
        EntityManager em = emf.createEntityManager();

        try {
             //Inicie a transação (opcional, dependendo da configuração do JPA)
           em.getTransaction().begin();

             //Realize a consulta usando JPQL (Java Persistence Query Language)
            String jpql = "SELECT p FROM prod_gunnebo p";
            List<ProdutoGunnebo> produtos = em.createQuery(jpql, ProdutoGunnebo.class).getResultList();

             //Faça algo com os resultados da consulta (exemplo: imprimir os registros)
             for (ProdutoGunnebo produto : produtos) {
                System.out.println(produto);
            }

            // Commit da transação (opcional, dependendo da configuração do JPA)
            em.getTransaction().commit();
        } catch (Exception e) {
            // Trate as exceções apropriadamente
            e.printStackTrace();
            // Realize rollback da transação em caso de erro (opcional, dependendo da configuração do JPA)
            em.getTransaction().rollback();
        } finally {
            // Feche o EntityManager
            em.close();
        }

        // Feche o EntityManagerFactory
        emf.close();
    }
}
