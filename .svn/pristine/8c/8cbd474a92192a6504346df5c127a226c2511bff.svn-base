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

@Entity
@Table(name = "orcamentos")
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "num_orc")
    private String numOrc;

    @Column(name = "data_orc")
    @Temporal(TemporalType.DATE)
    private Date dataOrc;
    
    @Column(name = "vendedor")
    private String vendedor;
    
    @Column(name = "cliente")
    private String cliente;
    
    @Column(name = "contato")
    private String contato;
    
    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "cond_pgto")
    private String condicaoPgto;

    @Column(name = "cond_transporte")
    private String condicaoTransporte;

    @Column(name = "total_orc")
    private BigDecimal totalOrc;

    public Orcamento() {
        // Construtor padrão
    }

    // Getters e Setters
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

    public Date getDataOrc() {
        return dataOrc;
    }

    public void setDataOrc(Date dataOrc) {
        this.dataOrc = dataOrc;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCondicaoPgto() {
        return condicaoPgto;
    }

    public void setCondicaoPgto(String condicaoPgto) {
        this.condicaoPgto = condicaoPgto;
    }

    public String getCondicaoTransporte() {
        return condicaoTransporte;
    }

    public void setCondicaoTransporte(String condicaoTransporte) {
        this.condicaoTransporte = condicaoTransporte;
    }

    public BigDecimal getTotalOrc() {
        return totalOrc;
    }

    public void setTotalOrc(BigDecimal totalOrc) {
        this.totalOrc = totalOrc;
    }

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Orcamento orcamento = (Orcamento) o;
       return id == orcamento.id
                && Objects.equals(numOrc, orcamento.numOrc)
                && Objects.equals(dataOrc, orcamento.dataOrc)
                && Objects.equals(vendedor, orcamento.vendedor)
                && Objects.equals(cliente, orcamento.cliente)
                && Objects.equals(cnpj, orcamento.cnpj)
                && Objects.equals(contato, orcamento.contato)
                && Objects.equals(condicaoPgto, orcamento.condicaoPgto)
                && Objects.equals(condicaoTransporte, orcamento.condicaoTransporte)
                && Objects.equals(totalOrc, orcamento.totalOrc);
               
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numOrc, dataOrc, vendedor, cliente, cnpj, contato, condicaoPgto, condicaoTransporte, totalOrc);
    }

    // ToString
    @Override
    public String toString() {
        return "Orcamento{"
                + "id='" + id + '\''
                + ",numOrc='" + numOrc + '\''
                + ", dataOrc=" + dataOrc
                + ", vendedor='" + vendedor + '\''
                + ", cliente='" + cliente + '\''
                + ", contato='" + contato + '\''
                + ", cnpj='" + cnpj + '\''
                + ", condicaoPgto='" + condicaoPgto + '\''
                + ", condicaoTransporte='" + condicaoTransporte + '\''
                + ", totalOrc=" + totalOrc
                + '}';
    }

}
