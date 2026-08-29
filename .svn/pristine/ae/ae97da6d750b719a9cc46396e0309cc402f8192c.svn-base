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

@Entity
@Table(name = "orc_lingas")
public class OrcLingas implements Serializable {

    private static final long serialVersionUID = 1L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "num_orc")
    private String numOrc;

    @Column(name = "modelo_linga")
    private String modeloLinga;
    
    @Column(name = "ref_acessorio")
    private String refAcessorio;

    @Column(name = "qtde_acessorio")
    private BigDecimal qtdeAcessorio;

    @Column(name = "valor_acessorio")
    private BigDecimal valorAcessorio;
    
    @Column(name = "total_acessorio")
    private BigDecimal totalAcessorio;

    @Column(name = "qtde_elos")
    private int qtdeElos;

    @Column(name = "qtde_metros")
    private BigDecimal qtdeMetros;
    
     public OrcLingas() {
        // Construtor padrão
    }


    // getters and setters

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

    public String getModeloLinga() {
        return modeloLinga;
    }

    public void setModeloLinga(String modeloLinga) {
        this.modeloLinga = modeloLinga;
    }

    public BigDecimal getQtdeAcessorio() {
        return qtdeAcessorio;
    }

    public void setQtdeAcessorio(BigDecimal qtdeAcessorio) {
        this.qtdeAcessorio = qtdeAcessorio;
    }

    public String getRefAcessorio() {
        return refAcessorio;
    }

    public void setRefAcessorio(String refAcessorio) {
        this.refAcessorio = refAcessorio;
    }

    public BigDecimal getValorAcessorio() {
        return valorAcessorio;
    }

    public void setValorAcessorio(BigDecimal valorAcessorio) {
        this.valorAcessorio = valorAcessorio;
    }

    public BigDecimal getTotalAcessorio() {
        return totalAcessorio;
    }
    
     public void setTotalAcessorio(BigDecimal totalAcessorio) {
        this.totalAcessorio = totalAcessorio;
    }

    public int getQtdeElos() {
        return qtdeElos;
    }

    public void setQtdeElos(int qtdeElos) {
        this.qtdeElos = qtdeElos;
    }

    public BigDecimal getQtdeMetros() {
        return qtdeMetros;
    }

    public void setQtdeMetros(BigDecimal qtdeMetros) {
        this.qtdeMetros = qtdeMetros;
    }
    
    
@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrcLingas orcLingas = (OrcLingas) o;
        return Objects.equals(numOrc, orcLingas.numOrc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOrc);
    }

    @Override
    public String toString() {
        return "OrcLingas{"
                + "id=" + id
                + ", numOrc='" + numOrc + '\''
                + ", modeloLinga='" + modeloLinga + '\''
                + ", refAcessorio=" + refAcessorio
                + ", qtdeAcessorio='" + qtdeAcessorio + '\''
                + ", valorAcessorio=" + valorAcessorio
                + ", totalAcessorio=" + totalAcessorio
                + ", qtdeElos=" + qtdeElos
                + ", qtdemetros=" + qtdeMetros
                + '}';
    }

}

