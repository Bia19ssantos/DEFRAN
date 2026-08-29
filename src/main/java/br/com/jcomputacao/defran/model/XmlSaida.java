package br.com.jcomputacao.defran.model;

/**
 *
 * @author thiago
 */
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
@Table(name = "xml_saida")
public class XmlSaida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_nfiscal")
    private String idNfiscal;

    @Column(name = "num_pedido")
    private Integer numPedido;

    @Column(name = "num_nfiscal")
    private Integer numNfiscal;

    private String cfop;

    @Temporal(TemporalType.DATE)
    private Date data;

    private String cliente;

    private Integer item;

    private String codigo;

    private String descricao;

    private String ncm;

    private Integer qtde;

    private String tipo;

    private BigDecimal valor;

    @Column(name = "porcent_icms")
    private BigDecimal porcentIcms;

    @Column(name = "valor_icms")
    private BigDecimal valorIcms;

    @Column(name = "porcent_pis")
    private BigDecimal porcentPis;

    @Column(name = "valor_pis")
    private BigDecimal valorPis;

    @Column(name = "porcent_cofins")
    private BigDecimal porcentCofins;

    @Column(name = "valor_cofins")
    private BigDecimal valorCofins;

    @Column(name = "total_item")
    private BigDecimal totalItem;

    public XmlSaida() {
        // Construtor padrão
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNfiscal() {
        return idNfiscal;
    }

    public void setIdNfiscal(String idNfiscal) {
        this.idNfiscal = idNfiscal;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Integer getNumNfiscal() {
        return numNfiscal;
    }

    public void setNumNfiscal(Integer numNfiscal) {
        this.numNfiscal = numNfiscal;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPorcentIcms() {
        return porcentIcms;
    }

    public void setPorcentIcms(BigDecimal porcentIcms) {
        this.porcentIcms = porcentIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getPorcentPis() {
        return porcentPis;
    }

    public void setPorcentPis(BigDecimal porcentPis) {
        this.porcentPis = porcentPis;
    }

    public BigDecimal getValorPis() {
        return valorPis;
    }

    public void setValorPis(BigDecimal valorPis) {
        this.valorPis = valorPis;
    }

    public BigDecimal getPorcentCofins() {
        return porcentCofins;
    }

    public void setPorcentCofins(BigDecimal porcentCofins) {
        this.porcentCofins = porcentCofins;
    }

    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    public BigDecimal getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(BigDecimal totalItem) {
        this.totalItem = totalItem;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlSaida that = (XmlSaida) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(idNfiscal, that.idNfiscal) &&
                Objects.equals(numPedido, that.numPedido) &&
                Objects.equals(numNfiscal, that.numNfiscal) &&
                Objects.equals(cfop, that.cfop) &&
                Objects.equals(data, that.data) &&
                Objects.equals(cliente, that.cliente) &&
                Objects.equals(item, that.item) &&
                Objects.equals(codigo, that.codigo) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(ncm, that.ncm) &&
                Objects.equals(qtde, that.qtde) &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(porcentIcms, that.porcentIcms) &&
                Objects.equals(valorIcms, that.valorIcms) &&
                Objects.equals(porcentPis, that.porcentPis) &&
                Objects.equals(valorPis, that.valorPis) &&
                Objects.equals(porcentCofins, that.porcentCofins) &&
                Objects.equals(valorCofins, that.valorCofins) &&
                Objects.equals(totalItem, that.totalItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idNfiscal, numPedido, numNfiscal, cfop, data, cliente, item, codigo, descricao, ncm,
                qtde, tipo, valor, porcentIcms, valorIcms, porcentPis, valorPis, porcentCofins, valorCofins, totalItem);
    }

    // ToString
    @Override
    public String toString() {
        return "XmlSaida{" +
                "id=" + id +
                ", idNfiscal='" + idNfiscal + '\'' +
                ", numPedido=" + numPedido +
                ", numNfiscal=" + numNfiscal +
                ", cfop='" + cfop + '\'' +
                ", data=" + data +
                ", cliente='" + cliente + '\'' +
                ", item=" + item +
                ", codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", ncm='" + ncm + '\'' +
                ", qtde=" + qtde +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", porcentIcms=" + porcentIcms +
                ", valorIcms=" + valorIcms +
                ", porcentPis=" + porcentPis +
                ", valorPis=" + valorPis +
                ", porcentCofins=" + porcentCofins +
                ", valorCofins=" + valorCofins +
                ", totalItem=" + totalItem +
                '}';
    }
}

