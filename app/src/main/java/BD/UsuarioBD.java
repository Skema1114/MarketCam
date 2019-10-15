package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interacao.Usuario;

/**
 * Created by Rafael Martins on 01/12/2016.
 */

public class UsuarioBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public UsuarioBD(Context context) {
        dataBaseHelper = new Conecta(context);
    }


    public SQLiteDatabase getDataBase() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        }
        return sqLiteDatabase;
    }


    public void fechar() {
        dataBaseHelper.close();
        dataBaseHelper = null;
    }


    private Usuario criarUsuario(Cursor cursor){
        Usuario usuario = new Usuario(
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario.ID_USUARIO)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario.FOTO_USUARIO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario.CARTAO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario.ENDERECO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario.NIVEL_ACESSO_ID)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.NOME)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.DATA_NASCIMENTO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.TELEFONE)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.SEXO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.EMAIL)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.SENHA)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.CRIADO)),         //ESSES ERA DO TIPO DATE
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.MODIFICADO)),     //ESSES ERA DO TIPO DATE
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.PERFIL_USUARIO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.STATUS_USUARIO)));


        return usuario;
    }


    /*INICIO DA EDIÇÃO 02/12/2016 08:56*/
    public List<Usuario> ListaUsuario(){
        Cursor cursor = getDataBase().query(Conecta.Usuario.TABELA,
                Conecta.Usuario.COLUNAS, null, null, null, null, null);

        List<Usuario> usuario = new ArrayList<Usuario>();

        while (cursor.moveToNext()) {
            Usuario modelo = criarUsuario(cursor);
            usuario.add(modelo);
        }
        cursor.close();
        return usuario;
    }


    public long salvarUsuario(Usuario usuario) {
        ContentValues valores = new ContentValues();
        valores.put(Conecta.Usuario.FOTO_USUARIO_ID, "2");
        valores.put(Conecta.Usuario.CARTAO_ID, "2");
        valores.put(Conecta.Usuario.ENDERECO_ID, "2");
        valores.put(Conecta.Usuario.NIVEL_ACESSO_ID, usuario.getNivel_acesso_id());
        valores.put(Conecta.Usuario.NOME, usuario.getNome());
        valores.put(Conecta.Usuario.DATA_NASCIMENTO, "2016-11-11 16:08:38");
        valores.put(Conecta.Usuario.TELEFONE, usuario.getTelefone());
        valores.put(Conecta.Usuario.SEXO, usuario.getSexo());
        valores.put(Conecta.Usuario.EMAIL, usuario.getEmail());
        valores.put(Conecta.Usuario.SENHA, usuario.getSenha());
        valores.put(Conecta.Usuario.CRIADO, "2016-11-11 16:08:38");
        valores.put(Conecta.Usuario.MODIFICADO, "2016-11-11 16:08:38");
        valores.put(Conecta.Usuario.PERFIL_USUARIO, usuario.getPerfil_usuario());
        valores.put(Conecta.Usuario.STATUS_USUARIO, "ativo");

        if (usuario.getId_usuario() != null) {
            return sqLiteDatabase.update(Conecta.Usuario.TABELA, valores, "id_usuario = ?",
                    new String[]{usuario.getId_usuario().toString()}
            );
        }
        return getDataBase().insert(Conecta.Usuario.TABELA, null, valores);
    }


    public boolean removerUsuario(int id) {
        return getDataBase().delete(Conecta.Usuario.TABELA, "id_usuario = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Usuario buscarUsuario(int id) {
        Cursor cursor = getDataBase().query(Conecta.Usuario.TABELA, Conecta.Usuario.COLUNAS, "id_usuario = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Usuario> usuario = new ArrayList<Usuario>() ;

        while(cursor.moveToNext()){
            Usuario modelo = criarUsuario(cursor) ;
            usuario.add(modelo);
            cursor.close();
            return modelo ;
        }
        return null;
    }

    public boolean logar (String usuario , String senha) {
        Cursor cursor = getDataBase().query(Conecta.Usuario.TABELA, null, "EMAIL = ? AND SENHA = ?", new String[]{usuario, senha}, null, null, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }
}