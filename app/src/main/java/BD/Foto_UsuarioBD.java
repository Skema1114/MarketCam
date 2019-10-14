package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Foto_Usuario;
import interacao.Usuario_Lista_Produto;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class Foto_UsuarioBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public Foto_UsuarioBD(Context context) {
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


    private Foto_Usuario criarFoto_Usuario(Cursor cursor){
        Foto_Usuario foto_usuario = new Foto_Usuario(
                cursor.getInt(cursor.getColumnIndex(Conecta.Foto_Usuario.ID_FOTO_USUARIO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Foto_Usuario.FOTO)));

        return foto_usuario;
    }


    public List<Foto_Usuario> ListaFoto_Usuario(){
        Cursor cursor = getDataBase().query(Conecta.Foto_Usuario.TABELA,
                Conecta.Foto_Usuario.COLUNAS, null, null, null, null, null);

        List<Foto_Usuario> foto_usuario = new ArrayList<Foto_Usuario>();

        while (cursor.moveToNext()) {
            Foto_Usuario modelo = criarFoto_Usuario(cursor);
            foto_usuario.add(modelo);
        }
        cursor.close();
        return foto_usuario;
    }


    public long salvarFoto_Usuario(Foto_Usuario foto_usuario) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Foto_Usuario.FOTO, foto_usuario.getFoto());

        if (foto_usuario.getId_foto_usuario() != null) {
            return sqLiteDatabase.update(Conecta.Foto_Usuario.TABELA, valores, "id_foto_usuario = ?",
                    new String[]{foto_usuario.getId_foto_usuario().toString()}
            );
        }
        return getDataBase().insert(Conecta.Foto_Usuario.TABELA, null, valores);
    }


    public boolean removerFoto_Usuario(int id) {
        return getDataBase().delete(Conecta.Foto_Usuario.TABELA, "id_foto_usuario  = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Foto_Usuario buscarFoto_Usuario(int id) {
        Cursor cursor = getDataBase().query(Conecta.Foto_Usuario.TABELA, Conecta.Foto_Usuario.COLUNAS, "id_foto_usuario  = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Foto_Usuario> foto_usuario = new ArrayList<Foto_Usuario>() ;

        while(cursor.moveToNext()){
            Foto_Usuario modelo = criarFoto_Usuario(cursor) ;
            foto_usuario.add(modelo);
            cursor.close();
            return modelo ;
        }
        return null;
    }

    /*public boolean logar (String usuario , String senha) {
        Cursor cursor = getDataBase().query(Conecta.Usuario.TABELA, null, "EMAIL = ? AND SENHA = ?", new String[]{usuario, senha}, null, null, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }*/
}
