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
@Table(name = "manilhas_crosby")
public class ManilhasCrosby implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ref_prod")
    private String refProd;

    @Column(name = "desc_prod")
    private String descProd;

    private String ncm;
    private String sap;
    private double ipi;
    private String tipo;

    @Column(name = "valor_custo")
    private double valorCusto;

    @Column(name = "carga_trabalho")
    private double cargaTrabalho;

    private double comprimento;

    @Column(name = "valor_venda")
    private double valorVenda;

    public ManilhasCrosby() {
        // Construtor padrão
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefProd() {
        return refProd;
    }

    public void setRefProd(String ref_prod) {
        this.refProd = ref_prod;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String desc_prod) {
        this.descProd = desc_prod;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getSap() {
        return sap;
    }

    public void setSap(String sap) {
        this.sap = sap;
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

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valor_custo) {
        this.valorCusto = valor_custo;
    }

    public double getCargaTrabalho() {
        return cargaTrabalho;
    }

    public void setCargaTrabalho(double carga_trabalho) {
        this.cargaTrabalho = carga_trabalho;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valor_venda) {
        this.valorVenda = valor_venda;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManilhasCrosby that = (ManilhasCrosby) o;
        return id == that.id &&
                
                Double.compare(that.ipi, ipi) == 0 &&
                Double.compare(that.valorCusto, valorCusto) == 0 &&
                Double.compare(that.cargaTrabalho, cargaTrabalho) == 0 &&
                Double.compare(that.comprimento, comprimento) == 0 &&
                Double.compare(that.valorVenda, valorVenda) == 0 &&
                Objects.equals(refProd, that.refProd) &&
                Objects.equals(descProd, that.descProd) &&
                Objects.equals(ncm, that.ncm) &&
                Objects.equals(sap, that.sap) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, refProd, descProd, ncm, sap, ipi, tipo, valorCusto, cargaTrabalho, comprimento, valorVenda);
    }

    // ToString
    @Override
    public String toString() {
        return "ManilhasCrosby{" +
                "id=" + id +
                ", ref_prod='" + refProd + '\'' +
                ", desc_prod='" + descProd + '\'' +
                ", ncm='" + ncm + '\'' +
                ", sap='" + sap + '\'' +
                ", ipi=" + ipi +
                ", tipo='" + tipo + '\'' +
                ", valor_custo=" + valorCusto +
                ", carga_trabalho=" + cargaTrabalho +
                ", comprimento=" + comprimento +
                ", valor_venda=" + valorVenda +
                '}';
    }

  
}
