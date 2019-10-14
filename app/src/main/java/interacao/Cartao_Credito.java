package interacao;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Cartao_Credito {
    private Integer id_cartao;
    private String titular_cartao;
    private String numero_cartao;
    private String validade_cartao;
    private String codigo_cartao;
    private String salvar_codigo_cartao;


    public Cartao_Credito(){

    }


    public Cartao_Credito(Integer id_cartao, String titular_cartao, String numero_cartao, String validade_cartao, String codigo_cartao, String salvar_codigo_cartao){
        this.id_cartao = id_cartao;
        this.titular_cartao = titular_cartao;
        this.numero_cartao = numero_cartao;
        this.validade_cartao = validade_cartao;
        this.codigo_cartao = codigo_cartao;
        this.salvar_codigo_cartao = salvar_codigo_cartao;
    }


    public Integer getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(Integer id_cartao) {
        this.id_cartao = id_cartao;
    }

    public String getTitular_cartao() {
        return titular_cartao;
    }

    public void setTitular_cartao(String titular_cartao) {
        this.titular_cartao = titular_cartao;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public String getValidade_cartao() {
        return validade_cartao;
    }

    public void setValidade_cartao(String validade_cartao) {
        this.validade_cartao = validade_cartao;
    }

    public String getCodigo_cartao() {
        return codigo_cartao;
    }

    public void setCodigo_cartao(String codigo_cartao) {
        this.codigo_cartao = codigo_cartao;
    }

    public String getSalvar_codigo_cartao() {
        return salvar_codigo_cartao;
    }

    public void setSalvar_codigo_cartao(String salvar_codigo_cartao) {
        this.salvar_codigo_cartao = salvar_codigo_cartao;
    }
}
