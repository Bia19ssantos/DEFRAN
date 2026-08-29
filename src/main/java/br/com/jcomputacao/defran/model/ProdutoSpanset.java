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
@Table(name = "prod_spanset")
public class ProdutoSpanset implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigo;

    @Column(name = "ref_prod")
    private String refProd;

    @Column(name = "desc_prod")
    private String descProd;

    private String ncm;

    @Column(name = "valor_custo")
    private double valorCusto;

    private String tipo;

    private double icms;

    @Column(name = "valor_venda")
    private double valorVenda;

    public ProdutoSpanset() {
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

    public String getReferenciaProduto() {
        return refProd;
    }

    public void setReferenciaProduto(String referenciaProduto) {
        this.refProd = referenciaProduto;
    }

    public String getDescricaoProduto() {
        return descProd;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descProd = descricaoProduto;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getIcms() {
        return icms;
    }

    public void setIcms(double icms) {
        this.icms = icms;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoSpanset that = (ProdutoSpanset) o;
        return id == that.id &&
                Double.compare(that.valorCusto, valorCusto) == 0 &&
                Double.compare(that.icms, icms) == 0 &&
                Double.compare(that.valorVenda, valorVenda) == 0 &&
                Objects.equals(codigo, that.codigo) &&
                Objects.equals(refProd, that.refProd) &&
                Objects.equals(descProd, that.descProd) &&
                Objects.equals(ncm, that.ncm) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, refProd, descProd, ncm, valorCusto, tipo, icms, valorVenda);
    }

    // ToString
    @Override
    public String toString() {
        return "ProdutoSpanset{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", referenciaProduto='" + refProd + '\'' +
                ", descricaoProduto='" + descProd + '\'' +
                ", ncm='" + ncm + '\'' +
                ", valorCusto=" + valorCusto +
                ", tipo='" + tipo + '\'' +
                ", icms=" + icms +
                ", valorVenda=" + valorVenda +
                '}';
    }
}

