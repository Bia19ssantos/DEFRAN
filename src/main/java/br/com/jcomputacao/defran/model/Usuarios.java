package br.com.jcomputacao.defran.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "usuario")
    private String user;

    @Column(name = "senha")
    private String senha;

    @Column(name = "redefinirSenha")
    private String redefinirSenha;

    @Column(name = "ativo", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean ativo;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRedefinirSenha() {
        return redefinirSenha;
    }

    public void setRedefinirSenha(String redefinirSenha) {
        this.redefinirSenha = redefinirSenha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
        Usuarios usuarios = (Usuarios) o;
        return id == usuarios.id
                && ativo == usuarios.ativo
                && Objects.equals(nome, usuarios.nome)
                && Objects.equals(this.user, usuarios.user)
                && Objects.equals(senha, usuarios.senha)
                && Objects.equals(redefinirSenha, usuarios.redefinirSenha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, this.user, senha, redefinirSenha, ativo);
    }

    // ToString
    @Override
    public String toString() {
        return "Usuarios{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", user='" + this.user + '\''
                + ", senha='" + senha + '\''
                + ", senha='" + redefinirSenha + '\''
                + ", ativo=" + ativo
                + '}';
    }
}
