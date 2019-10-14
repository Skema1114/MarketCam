package interacao;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Carrinho {
    private Integer id_carrinho;
    private Integer usuario_id;
    private Integer produto_id;
    private Integer quantidade;
    private double valor_total;


    public Carrinho(){

    }

    public Carrinho(Integer id_carrinho, Integer usuario_id, Integer produto_id, Integer quantidade, double valor_total){
        this.id_carrinho = id_carrinho;
        this.usuario_id = usuario_id;
        this.produto_id = produto_id;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
    }


    public Integer getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(Integer id_carrinho) {
        this.id_carrinho = id_carrinho;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
}
