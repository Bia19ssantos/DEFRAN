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
import br.com.jcomputacao.defran.model.ItensOrcamentos;
import br.com.jcomputacao.defran.model.ItensOrcamentos;
import br.com.jcomputacao.defran.model.Orcamento;
import br.com.jcomputacao.defran.model.Orcamento;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItensOrcamentosDAO {
    private Session session;

    public ItensOrcamentosDAO(Session session) {
        this.session = session;
    }

    public void salvar(ItensOrcamentos item) {
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
    }

    public List<ItensOrcamentos> listarItensPorOrcamento(Orcamento orcamento) {
        return session.createQuery("FROM ItensOrcamentos WHERE orcamento = :orcamento", ItensOrcamentos.class)
                .setParameter("orcamento", orcamento)
                .list();
    }

    // Outros métodos DAO, como atualizar, excluir e buscar por ID
}