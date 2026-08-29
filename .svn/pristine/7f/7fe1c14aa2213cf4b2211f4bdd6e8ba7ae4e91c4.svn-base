/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DEFRAN-4
 */

@Entity
@Table(name = "vendas")
public class Vendas implements Serializable {

     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "num_pedido")
    private String numPedido;
    
    @Column(name = "num_orc")
    private String numOrc;
    
    @Column(name = "data_pedido")
    private Date dataPedido;
    
    @Column(name = "cliente")
    private String cliente;
    
    @Column(name = "data_NF")
    private Date dataNF;
    
    @Column(name = "num_NF")
    private String numNF;
    
    @Column(name = "total_pedido")
    private BigDecimal totalPedido;

    
    public Vendas() {
        // Construtor padrão
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }
    
    public String getNumOrc() {
        return numOrc;
    }

    public void setNumOrc(String numOrc) {
        this.numOrc = numOrc;
    }
    
     public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataNF() {
        return dataNF;
    }

    public void setDataNF(Date dataNF) {
        this.dataNF = dataNF;
    }

    public String getNumNF() {
        return numNF;
    }

    public void setNumNF(String numNF) {
        this.numNF = numNF;
    }
    
    
    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }
    

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendas vendas = (Vendas) o;
        return id == vendas.id &&
                Objects.equals(numPedido, vendas.numPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numPedido);
    }

    // ToString
    @Override
    public String toString() {
        return "Vendas{" +
                "id=" + id +
                ", numPedido='" + numPedido + '\'' +
                ", numOrc='" + numOrc + '\'' +
                ", dataPedido=" + dataPedido +
                ", cliente='" + cliente + '\'' +
                ", dataNF=" + dataNF +
                ", numNF=" + numNF +
                ", totalPedido=" + totalPedido + 
                '}';
    }

}