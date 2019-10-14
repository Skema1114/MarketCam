package interacao;

import java.util.Date;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Foto_Usuario {
    private Integer id_foto_usuario;
    private String foto;                     //a mesma coisa de "Foto_Produto", ou seja, a foto ta em String para pegar o caminho do banco de dados


    private Foto_Usuario(){

    }


    public Foto_Usuario(Integer id_foto_usuario, String foto){
        this.id_foto_usuario = id_foto_usuario;
        this.foto = foto;
    }


    public Integer getId_foto_usuario() {
        return id_foto_usuario;
    }

    public void setId_foto_usuario(Integer id_foto_usuario) {
        this.id_foto_usuario = id_foto_usuario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
