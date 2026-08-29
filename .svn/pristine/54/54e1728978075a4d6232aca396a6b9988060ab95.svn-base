package br.com.jcomputacao.defran.model;

/**
 *
 * @author thiago
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mod_lingas")
public class ModLingas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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
}
