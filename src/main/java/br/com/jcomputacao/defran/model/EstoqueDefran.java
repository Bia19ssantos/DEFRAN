package br.com.jcomputacao.defran.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author thiago
 */

@Entity
@Table(name = "estoque_defran")
public class EstoqueDefran implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "ref_prod")
    private String refProd;

    @Column(name = "desc_prod")
    private String descProd;

    @Column(name = "qtde")
    private double qtde;

    // getters and setters

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

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }
       // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueDefran that = (EstoqueDefran) o;
        return id == that.id &&
                
                Objects.equals(codigo, that.codigo) &&
                Objects.equals(refProd, that.refProd) &&
                Objects.equals(descProd, that.descProd) &&
                Objects.equals(qtde, that.qtde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, refProd, descProd, qtde);
    }

    // ToString
    @Override
    public String toString() {
        return "EstoqueDefran{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", ref_prod='" + refProd + '\'' +
                ", desc_prod='" + descProd + '\'' +
                ", qtde='" + qtde + '\'' +
                '}';
    }
    
}