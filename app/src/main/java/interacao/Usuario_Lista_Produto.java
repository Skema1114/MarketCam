package interacao;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Usuario_Lista_Produto {
    private Integer id_usuario_lista_produto;
    private Integer produto_id;
    private Integer usuario_id;
    private Integer lista_id;
    private Integer quantidade;
    private double valor_total;


    public Usuario_Lista_Produto(){

    }


    public Usuario_Lista_Produto(Integer id_usuario_lista_produto, Integer produto_id, Integer usuario_id, Integer lista_id, Integer quantidade, double valor_total){
        this.id_usuario_lista_produto = id_usuario_lista_produto;
        this.produto_id = produto_id;
        this.usuario_id = usuario_id;
        this.lista_id = lista_id;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
    }


    public Integer getId_usuario_lista_produto() {
        return id_usuario_lista_produto;
    }

    public void setId_usuario_lista_produto(Integer id_usuario_lista_produto) {
        this.id_usuario_lista_produto = id_usuario_lista_produto;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getLista_id() {
        return lista_id;
    }

    public void setLista_id(Integer lista_id) {
        this.lista_id = lista_id;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }
}
