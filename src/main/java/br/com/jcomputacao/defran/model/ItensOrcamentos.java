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
 *
 */
@Entity
@Table(name = "itens_orcamentos")
public class ItensOrcamentos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private int id;
    
    @Column(name = "num_orc")
    private String numOrc;

    @Column(name = "item")
    private int item;

    @Column(name = "ncm")
    private String ncm;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "ref_prod")
    private String refProd;

    @Column(name = "desc_prod")
    private String descProd;

    @Column(name = "qtde", precision = 8, scale = 2)
    private BigDecimal qtde;

    @Column(name = "valor_unit", precision = 10, scale = 2)
    private BigDecimal valorUnit;

    @Column(name = "total_item", precision = 10, scale = 2)
    private BigDecimal totalItem;

    @Column(name = "prazo_entrega")
    private String prazoEntrega;

    public ItensOrcamentos() {
        // Construtor padrão
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumOrc() {
        return numOrc;
    }

  public void setNumOrc(String numOrc) {
        this.numOrc = numOrc;
    }
  
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
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

    public String getRefProd() {
        return refProd;
    }

    public void setRefProd(String refProd) {
        this.refProd = refProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public BigDecimal getQtde() {
        return qtde;
    }

    public void setQtde(BigDecimal qtde) {
        this.qtde = qtde;
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

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItensOrcamentos itensOrcamentos = (ItensOrcamentos) o;
       return id == itensOrcamentos.id
                && Objects.equals(numOrc, itensOrcamentos.numOrc)
               && Objects.equals(item, itensOrcamentos.item)
                && Objects.equals(refProd, itensOrcamentos.refProd)
                && Objects.equals(descProd, itensOrcamentos.descProd)
                && Objects.equals(ncm, itensOrcamentos.ncm)
                && Objects.equals(tipo, itensOrcamentos.tipo)
                && Objects.equals(qtde, itensOrcamentos.qtde)
                && Objects.equals(valorUnit, itensOrcamentos.valorUnit)
                && Objects.equals(totalItem, itensOrcamentos.totalItem)
                && Objects.equals(prazoEntrega, itensOrcamentos.prazoEntrega);
               
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numOrc, item, refProd, descProd, ncm, tipo, qtde, valorUnit, totalItem, prazoEntrega);
    }

    @Override
    public String toString() {
        return "ItensOrcamentos{"
                + "id=" + id
                + ", numOrc=" + numOrc + '\''
                + ", item=" + item
                + ", ncm='" + ncm + '\''
                + ", tipo='" + tipo + '\''
                + ", refProd='" + refProd + '\''
                + ", descProd='" + descProd + '\''
                + ", qtde=" + qtde
                + ", valorUnit=" + valorUnit
                + ", totalItem=" + totalItem
                + ", prazoEntrega=" + prazoEntrega
                + '}';
    }

    public void setRowIndex(int rowIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
