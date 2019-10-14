package interacao;

import java.util.Date;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Lista {
    private Integer id_lista;
    private String nome;
    private String data_hora;     //esse era string
    private double valor_total;


    public Lista(){

    }


    public Lista(Integer id_lista, String nome, String data_hora, double valor_total){
        this.id_lista = id_lista;
        this.nome = nome;
        this.data_hora = data_hora;
        this.valor_total = valor_total;
    }


    public Integer getId_lista() {
        return id_lista;
    }

    public void setId_lista(Integer id_lista) {
        this.id_lista = id_lista;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public String getData_hora() {return data_hora;}

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
