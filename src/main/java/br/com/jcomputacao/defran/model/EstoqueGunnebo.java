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
@Table(name = "estoque_gunnebo")
public class EstoqueGunnebo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "ref_prod")
    private String refProd;

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
        EstoqueGunnebo that = (EstoqueGunnebo) o;
        return id == that.id &&
                
                Objects.equals(codigo, that.codigo) &&
                Objects.equals(refProd, that.refProd) &&
                Objects.equals(qtde, that.qtde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, refProd, qtde);
    }

    // ToString
    @Override
    public String toString() {
        return "EstoqueGunnebo{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", ref_prod='" + refProd + '\'' +
                ", qtde='" + qtde +
                '}';
    }

    
}
