package br.com.jcomputacao.defran.model;

/**
 *
 * @author thiago
 */
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "razao")
    private String razao;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "contato")
    private String contato;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "celular")
    private String celular;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "email")
    private String email;

    @Column(name = "cond_pgto")
    private String condPgto;

    @Column(name = "cond_transporte")
    private String condTransporte;

    @Column(name = "cep")
    private String cep;

    @Column(name = "end_numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "bairro")
    private String bairro;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCondPgto() {
        return condPgto;
    }

    public void setCondPgto(String condPgto) {
        this.condPgto = condPgto;
    }

    public String getCondTransporte() {
        return condTransporte;
    }

    public void setCondTransporte(String condTransporte) {
        this.condTransporte = condTransporte;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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
        Clientes that = (Clientes) o;
        return id == that.id
                && Objects.equals(razao, that.razao)
                && Objects.equals(cnpj, that.cnpj)
                && Objects.equals(contato, that.contato)
                && Objects.equals(telefone, that.telefone)
                && Objects.equals(celular, that.celular)
                && Objects.equals(cidade, that.cidade)
                && Objects.equals(estado, that.estado)
                && Objects.equals(email, that.email)
                && Objects.equals(condPgto, that.condPgto)
                && Objects.equals(condTransporte, that.condTransporte)
                && Objects.equals(cep, that.cep)
                && Objects.equals(numero, that.numero)
                && Objects.equals(complemento, that.complemento)
                && Objects.equals(logradouro, that.logradouro)
                && Objects.equals(bairro, that.bairro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, razao, cnpj, contato, telefone, celular, cidade, estado, email, condPgto, condTransporte, cep, numero, complemento, logradouro, bairro);
    }

    // ToString
    @Override
    public String toString() {
        return "Clientes{"
                + "id=" + id
                + ", razao='" + razao + '\''
                + ", cnpj='" + cnpj + '\''
                + ", contato='" + contato + '\''
                + ", telefone='" + telefone + '\''
                + ", celular=" + celular
                + ", cidade='" + cidade + '\''
                + ", estado=" + estado
                + ", email=" + email
                + ", condPgto=" + condPgto
                + ", condTransporte=" + condTransporte
                + ", cep=" + cep
                + ", numero=" + numero
                + ", complemento=" + complemento
                + ", logradouro=" + logradouro
                + ", bairro=" + bairro
                + '}';
    }

}
