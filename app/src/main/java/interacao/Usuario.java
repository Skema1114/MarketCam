package interacao;

import java.util.Date;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class Usuario {
    private Integer id_usuario;
    private Integer foto_usuario_id;
    private Integer cartao_id;
    private Integer endereco_id;
    private Integer nivel_acesso_id;
    private String nome;
    private String data_nascimento;  //ERA NO FORMATO DATE
    private String telefone;
    private String sexo;
    private String email;
    private String senha;
    private String criado;         //ERA NO FORMATO DATE
    private String modificado;    //ERA NO FORMATO DATE
    private String perfil_usuario;
    private String status_usuario;


    public Usuario(){

    }


    public Usuario(Integer id_usuario, Integer foto_usuario_id, Integer cartao_id, Integer endereco_id, Integer nivel_acesso_id, String nome, String data_nascimento,
                   String telefone, String sexo, String email, String senha, String criado, String modificado, String perfil_usuario, String status_usuario){
        this.id_usuario = id_usuario;
        this.foto_usuario_id = foto_usuario_id;
        this.cartao_id = cartao_id;
        this.endereco_id = endereco_id;
        this.nivel_acesso_id = nivel_acesso_id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
        this.criado = criado;
        this.modificado = modificado;
        this.perfil_usuario = perfil_usuario;
        this.status_usuario = status_usuario;
    }


    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getFoto_usuario_id() {
        return foto_usuario_id;
    }

    public void setFoto_usuario_id(Integer foto_usuario_id) {
        this.foto_usuario_id = foto_usuario_id;
    }

    public Integer getCartao_id() {
        return cartao_id;
    }

    public void setCartao_id(Integer cartao_id) {
        this.cartao_id = cartao_id;
    }

    public Integer getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Integer endereco_id) {
        this.endereco_id = endereco_id;
    }

    public Integer getNivel_acesso_id() {
        return nivel_acesso_id;
    }

    public void setNivel_acesso_id(Integer nivel_acesso_id) {
        this.nivel_acesso_id = nivel_acesso_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getPerfil_usuario() {
        return perfil_usuario;
    }

    public void setPerfil_usuario(String perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    public String getStatus_usuario() {
        return status_usuario;
    }

    public void setStatus_usuario(String status_usuario) {
        this.status_usuario = status_usuario;
    }


}
