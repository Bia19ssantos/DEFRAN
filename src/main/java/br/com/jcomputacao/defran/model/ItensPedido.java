/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DEFRAN-4
 */
@Entity
@Table(name = "itens_pedido")
public class ItensPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "num_pedido")
    private String numPedido;

    @Column(name = "item")
    private int item;

    @Column(name = "ref_item")
    private String refItem;

    @Column(name = "ncm")
    private String ncm;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "qtde_item", precision = 8, scale = 2)
    private BigDecimal qtdeItem;

    @Column(name = "valor_unit", precision = 10, scale = 2)
    private BigDecimal valorUnit;

    @Column(name = "total_item", precision = 10, scale = 2)
    private BigDecimal totalItem;

    public ItensPedido() {
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

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getRefItem() {
        return refItem;
    }

    public void setRefItem(String refItem) {
        this.refItem = refItem;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getQtdeItem() {
        return qtdeItem;
    }

    public void setQtdeItem(BigDecimal qtdeItem) {
        this.qtdeItem = qtdeItem;
    }

    public BigDecimal getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(BigDecimal valorUnit) {
        this.valorUnit = valorUnit;
    }

    public BigDecimal getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(BigDecimal totalItem) {
        this.totalItem = totalItem;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItensPedido itensPedido = (ItensPedido) o;
        return id == itensPedido.id
                && Objects.equals(numPedido, itensPedido.numPedido)
                && Objects.equals(item, itensPedido.item)
                && Objects.equals(refItem, itensPedido.refItem)
                && Objects.equals(ncm, itensPedido.ncm)
                && Objects.equals(tipo, itensPedido.tipo)
                && Objects.equals(qtdeItem, itensPedido.qtdeItem)
                && Objects.equals(valorUnit, itensPedido.valorUnit)
                && Objects.equals(totalItem, itensPedido.totalItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numPedido, item, refItem, ncm, tipo, qtdeItem, valorUnit, totalItem);
    }

    @Override
    public String toString() {
        return "ItensPedido{"
                + "id=" + id
                + ", numPedido=" + numPedido
                + ", item='" + item
                + ", refItem='" + refItem + '\''
                + ", ncm='" + ncm + '\''
                + ", tipo='" + tipo + '\''
                + ", qtdeItem=" + qtdeItem
                + ", valorUnit=" + valorUnit
                + ", totalItem=" + totalItem
                + '}';
    }

}
