/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author DEFRAN-4
 */
@Entity
@Table(name = "mod_lingas")
public class ModelosLingas implements Serializable { 
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "ref_linga")
    private String refLinga;

    @Column(name = "desc_linga")
    private String descLinga;

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

    public String getRefLinga() {
        return refLinga;
    }

    public void setRefLinga(String refLinga) {
        this.refLinga = refLinga;
    }

    public String getDescLinga() {
        return descLinga;
    }

    public void setDescLinga(String descLinga) {
        this.descLinga = descLinga;
    }

    
       // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelosLingas that = (ModelosLingas) o;
        return id == that.id &&
                
                Objects.equals(codigo, that.codigo) &&
                Objects.equals(refLinga, that.refLinga) &&
                Objects.equals(descLinga, that.descLinga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, refLinga, descLinga);
    }

    // ToString
    @Override
    public String toString() {
        return "ModelosLingas{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", ref_linga='" + refLinga + '\'' +
                ", desc_linga='" + descLinga + '\'' +
                '}';
    }
    
}