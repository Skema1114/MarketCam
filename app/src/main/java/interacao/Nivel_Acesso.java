package interacao;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class Nivel_Acesso {
    private Integer id_nivel_acesso;
    private String nome;
    private String criado;
    private String modificado;


    public Nivel_Acesso(){

    }

    public Nivel_Acesso(Integer id_nivel_acesso, String nome, String criado, String modificado){
        this.id_nivel_acesso = id_nivel_acesso;
        this.nome = nome;
        this.criado = criado;
        this.nome = nome;
        this.modificado = modificado;
    }


    public Integer getId_nivel_acesso() {
        return id_nivel_acesso;
    }

    public void setId_nivel_acesso(Integer id_nivel_acesso) {
        this.id_nivel_acesso = id_nivel_acesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCriado() {
        return criado;
    }

    public void setCriado(String criado) {
        this.criado = criado;
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }
}
