package interacao;

import java.util.Date;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Produto {
    private Integer id_produto;
    private Integer foto_produto_id;
    private Integer codigo_barras;
    private String nome;
    private double valor;
    private String lote;
    private String descricao;

    private Produto(){

    }

    public Produto(Integer id_produto, Integer foto_produto_id, Integer codigo_barras, String nome, double valor, String lote, String descricao){
        this.id_produto = id_produto;
        this.foto_produto_id = foto_produto_id;
        this.codigo_barras = codigo_barras;
        this.nome = nome;
        this.valor = valor;
        this.lote = lote;
        this.descricao = descricao;
    }


    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(Integer codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Integer getFoto_produto_id() {
        return foto_produto_id;
    }

    public void setFoto_produto_id(Integer foto_produto_id) {
        this.foto_produto_id = foto_produto_id;
    }
}
