package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Nivel_Acesso;
import interacao.Usuario_Lista_Produto;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class Nivel_AcessoBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public Nivel_AcessoBD(Context context) {
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


    private Nivel_Acesso criarNivel_Acesso(Cursor cursor){
        Nivel_Acesso nivel_acesso = new Nivel_Acesso(
                cursor.getInt(cursor.getColumnIndex(Conecta.Nivel_Acesso.ID_NIVEL_ACESSO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Nivel_Acesso.NOME)),
                cursor.getString(cursor.getColumnIndex(Conecta.Nivel_Acesso.CRIADO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Nivel_Acesso.MODIFICADO)));


        return nivel_acesso;
    }


    public List<Nivel_Acesso> ListaNivel_Acesso(){
        Cursor cursor = getDataBase().query(Conecta.Nivel_Acesso.TABELA,
                Conecta.Nivel_Acesso.COLUNAS, null, null, null, null, null);

        List<Nivel_Acesso> nivel_acesso = new ArrayList<Nivel_Acesso>();

        while (cursor.moveToNext()) {
            Nivel_Acesso modelo = criarNivel_Acesso(cursor);
            nivel_acesso.add(modelo);
        }
        cursor.close();
        return nivel_acesso;
    }


    public long salvarNivel_Acesso(Nivel_Acesso nivel_acesso) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Nivel_Acesso.NOME, nivel_acesso.getNome());
        valores.put(Conecta.Nivel_Acesso.CRIADO, nivel_acesso.getCriado());
        valores.put(Conecta.Nivel_Acesso.MODIFICADO, nivel_acesso.getModificado());

        if (nivel_acesso.getId_nivel_acesso() != null) {
            return sqLiteDatabase.update(Conecta.Nivel_Acesso.TABELA, valores, "id_nivel_acesso = ?",
                    new String[]{nivel_acesso.getId_nivel_acesso().toString()}
            );
        }
        return getDataBase().insert(Conecta.Nivel_Acesso.TABELA, null, valores);
    }


    public boolean removerNivel_Acesso(int id) {
        return getDataBase().delete(Conecta.Nivel_Acesso.TABELA, "id_nivel_acesso = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Nivel_Acesso buscarNivel_Acesso(int id) {
        Cursor cursor = getDataBase().query(Conecta.Nivel_Acesso.TABELA, Conecta.Nivel_Acesso.COLUNAS, "id_nivel_acesso = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Nivel_Acesso> nivel_acesso = new ArrayList<Nivel_Acesso>() ;

        while(cursor.moveToNext()){
            Nivel_Acesso modelo = criarNivel_Acesso(cursor) ;
            nivel_acesso.add(modelo);
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

