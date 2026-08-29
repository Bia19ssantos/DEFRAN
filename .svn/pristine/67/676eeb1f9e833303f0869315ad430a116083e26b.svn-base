/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jcomputacao.defran.model;

/**
 *
 * @author thiago
 */
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prod_pewag")
public class ProdutoPewag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigo;

    @Column(name = "ref_gunnebo")
    private String refGunnebo;

    @Column(name = "ref_pewag")
    private String refPewag;

    @Column(name = "desc_prod")
    private String descProd;

    private String ncm;
    private double icms;
    private double ipi;
    private String tipo;

    private double comprimento;

    @Column(name = "valor_custo")
    private double valorCusto;

    @Column(name = "valor_venda")
    private double valorVenda;

    public ProdutoPewag() {
        // Construtor padrão
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRefGunnebo() {
        return refGunnebo;
    }

    public void setRefGunnebo(String refGunnebo) {
        this.refGunnebo = refGunnebo;
    }

    public String getRefPewag() {
        return refPewag;
    }

    public void setRefPewag(String refPewag) {
        this.refPewag = refPewag;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public double getIcms() {
        return icms;
    }

    public void setIcms(double icms) {
        this.icms = icms;
    }

    public double getIpi() {
        return ipi;
    }

    public void setIpi(double ipi) {
        this.ipi = ipi;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProdutoPewag that = (ProdutoPewag) o;
        return id == that.id
                && Double.compare(that.icms, icms) == 0
                && Double.compare(that.ipi, ipi) == 0
                && Double.compare(that.valorCusto, valorCusto) == 0
                && Double.compare(that.valorVenda, valorVenda) == 0
                && Objects.equals(codigo, that.codigo)
                && Objects.equals(refGunnebo, that.refGunnebo)
                && Objects.equals(refPewag, that.refPewag)
                && Objects.equals(descProd, that.descProd)
                && Objects.equals(ncm, that.ncm)
                && Double.compare(that.comprimento, comprimento) == 0
                && Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, refGunnebo, refPewag, descProd, ncm, icms, ipi, tipo, comprimento, valorCusto, valorVenda);
    }

    // ToString
    @Override
    public String toString() {
        return "ProdutoPewag{"
                + "id=" + id
                + ", codigo='" + codigo + '\''
                + ", refGunnebo='" + refGunnebo + '\''
                + ", refPewag='" + refPewag + '\''
                + ", descProd='" + descProd + '\''
                + ", ncm='" + ncm + '\''
                + ", icms=" + icms
                + ", ipi=" + ipi
                + ", tipo='" + tipo + '\''
                + ", comprimento='" + comprimento + '\''
                + ", valorCusto=" + valorCusto
                + ", valorVenda=" + valorVenda
                + '}';
    }
}
