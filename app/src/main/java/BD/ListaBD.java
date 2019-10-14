package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Lista;
import interacao.Usuario;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class ListaBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public ListaBD(Context context) {
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


    private Lista criarLista(Cursor cursor){
        Lista lista = new Lista(
                cursor.getInt(cursor.getColumnIndex(Conecta.Lista.ID_LISTA)),
                cursor.getString(cursor.getColumnIndex(Conecta.Lista.NOME)),
                cursor.getString(cursor.getColumnIndex(Conecta.Lista.DATA_HORA)),
                cursor.getDouble(cursor.getColumnIndex(Conecta.Lista.VALOR_TOTAL)));

        return lista;
    }


    public List<Lista> ListaLista(){
        Cursor cursor = getDataBase().query(Conecta.Lista.TABELA,
                Conecta.Lista.COLUNAS, null, null, null, null, null);

        List<Lista> lista = new ArrayList<Lista>();

        while (cursor.moveToNext()) {
            Lista modelo = criarLista(cursor);
            lista.add(modelo);
        }
        cursor.close();
        return lista;
    }


    public long salvarLista(Lista lista) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Lista.NOME, lista.getNome());
        valores.put(Conecta.Lista.DATA_HORA, lista.getData_hora());
        valores.put(Conecta.Lista.VALOR_TOTAL, lista.getValor_total());


        if (lista.getId_lista() != null) {
            return sqLiteDatabase.update(Conecta.Lista.TABELA, valores, "id_lista = ?",
                    new String[]{lista.getId_lista().toString()}
            );
        }
        return getDataBase().insert(Conecta.Lista.TABELA, null, valores);
    }


    public boolean removerLista(int id) {
        return getDataBase().delete(Conecta.Lista.TABELA, "id_lista = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Lista buscarLista(int id) {
        Cursor cursor = getDataBase().query(Conecta.Lista.TABELA, Conecta.Lista.COLUNAS, "id_lista = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Lista> lista = new ArrayList<Lista>() ;

        while(cursor.moveToNext()){
            Lista modelo = criarLista(cursor) ;
            lista.add(modelo);
            cursor.close();
            return modelo;
        }
        return null;
    }

    /*public boolean logar (String usuario , String senha) {
        Cursor cursor = getDataBase().query(Conecta.Lista.TABELA, null, "EMAIL = ? AND SENHA = ?", new String[]{usuario, senha}, null, null, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }*/
}

