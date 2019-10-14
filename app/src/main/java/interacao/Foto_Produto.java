package interacao;

import java.util.Date;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Foto_Produto {
    private Integer id_foto_produto;
    private String foto;                   //no banco a foto é mediumbloob, aqui é String para pegar o caminho da foto dop banco


    public Foto_Produto(){

    }


    public Foto_Produto(Integer id_foto_produto, String foto){
        this.id_foto_produto = id_foto_produto;
        this.foto = foto;
    }

    public Integer getId_foto_produto() {
        return id_foto_produto;
    }

    public void setId_foto_produto(Integer id_foto_produto) {
        this.id_foto_produto = id_foto_produto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
