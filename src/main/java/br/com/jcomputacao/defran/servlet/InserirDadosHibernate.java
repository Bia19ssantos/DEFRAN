/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import br.com.jcomputacao.defran.model.Orcamento;
import br.com.jcomputacao.defran.model.ItensOrcamentos;
import br.com.jcomputacao.defran.resources.HibernateUtil;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InserirDadosHibernate {

    public static void main(String[] args) {
// Inicialize o Hibernate e obtenha uma sessão
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // Inicie uma transação
        Transaction transaction = session.beginTransaction();

        try {
            // Crie um novo objeto Orcamento

            SimpleDateFormat sdf = new SimpleDateFormat("hh/mm");

            Orcamento orcamento = new Orcamento();
            orcamento.setNumOrc("5"); // Defina um valor válido para num_orc
            orcamento.setDataOrc(new Date());
            orcamento.setVendedor("João");
            orcamento.setCnpj("09.636.632/0001-99");
            orcamento.setCliente("Cliente ABC");
            orcamento.setContato("Claudia");
            orcamento.setCondicaoPgto("À vista");
            orcamento.setCondicaoTransporte("Posto na Transportadora em Porto Feliz");
            orcamento.setTotalOrc(new BigDecimal("1000.00"));

            ItensOrcamentos item1 = new ItensOrcamentos();
           // item1.setOrcamento(orcamento);
            item1.setItem(1);
            item1.setRefProd("REF-001");
            item1.setDescProd("Produto 1");
            item1.setNcm("12345678");
            item1.setTipo("Tipo A");
            item1.setQtde(new BigDecimal("10"));
            item1.setValorUnit(new BigDecimal("50.00"));
            item1.setTotalItem(new BigDecimal("500.00"));
            item1.setPrazoEntrega("5 dias");

            ItensOrcamentos item2 = new ItensOrcamentos();
            //item2.setOrcamento(orcamento);
            item2.setItem(2);
            item2.setRefProd("REF-002");
            item2.setDescProd("Produto 2");
            item2.setNcm("87654321");
            item2.setTipo("Tipo B");
            item2.setQtde(new BigDecimal("20"));
            item2.setValorUnit(new BigDecimal("60.00"));
            item2.setTotalItem(new BigDecimal("1200.00"));
            item2.setPrazoEntrega("7 dias");
            
            // Salve o objeto Orcamento no banco de dados
            session.save(orcamento);

            List<ItensOrcamentos> itens1 = new ArrayList<ItensOrcamentos>();
            itens1.add(item1);
            itens1.add(item2);
            //orcamento.setItens(itens1);


            // Comita a transação
            transaction.commit();

            System.out.println("Dados inseridos com sucesso!");

        } catch (Exception ex) {
            ex.printStackTrace();
            // Em caso de exceção, faça o rollback da transação
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            // Feche a sessão do Hibernate
            session.close();
        }
    }
}
