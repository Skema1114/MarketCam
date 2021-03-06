package interacao;

import java.util.Date;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Compra {
    private Integer id_compra;
    private Integer carrinho_id;
    private String data;             //esse era data
    private String hora;             //esse era data
    private String tag;
    private double valor_total;


    public Compra(){

    }


    public Compra(Integer id_compra, Integer carrinho_id, String data, String hora, String tag, double valor_total){
        this.id_compra = id_compra;
        this.carrinho_id = carrinho_id;
        this.data = data;
        this.hora = hora;
        this.tag = tag;
        this.valor_total = valor_total;
    }


    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getCarrinho_id() {
        return carrinho_id;
    }

    public void setCarrinho_id(Integer carrinho_id) {
        this.carrinho_id = carrinho_id;
    }

    public Integer getId_compra() {
        return id_compra;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }
}
