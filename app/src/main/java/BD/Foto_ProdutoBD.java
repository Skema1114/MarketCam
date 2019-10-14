package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Foto_Produto;
import interacao.Foto_Usuario;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class Foto_ProdutoBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public Foto_ProdutoBD(Context context) {
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


    private Foto_Produto criarFoto_Produto(Cursor cursor){
        Foto_Produto foto_produto = new Foto_Produto(
                cursor.getInt(cursor.getColumnIndex(Conecta.Foto_Produto.ID_FOTO_PRODUTO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Foto_Produto.FOTO)));

        return foto_produto;
    }


    public List<Foto_Produto> ListaFoto_Produto(){
        Cursor cursor = getDataBase().query(Conecta.Foto_Produto.TABELA,
                Conecta.Foto_Produto.COLUNAS, null, null, null, null, null);

        List<Foto_Produto> foto_produto = new ArrayList<Foto_Produto>();

        while (cursor.moveToNext()) {
            Foto_Produto modelo = criarFoto_Produto(cursor);
            foto_produto.add(modelo);
        }
        cursor.close();
        return foto_produto;
    }


    public long salvarFoto_Produto(Foto_Produto foto_produto) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Foto_Produto.FOTO, foto_produto.getFoto());

        if (foto_produto.getId_foto_produto() != null) {
            return sqLiteDatabase.update(Conecta.Foto_Produto.TABELA, valores, "id_foto_produto = ?",
                    new String[]{foto_produto.getId_foto_produto().toString()}
            );
        }
        return getDataBase().insert(Conecta.Foto_Produto.TABELA, null, valores);
    }


    public boolean removerFoto_Produto(int id) {
        return getDataBase().delete(Conecta.Foto_Produto.TABELA, "id_foto_produto  = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Foto_Produto buscarFoto_Produto(int id) {
        Cursor cursor = getDataBase().query(Conecta.Foto_Produto.TABELA, Conecta.Foto_Produto.COLUNAS, "id_foto_produto  = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Foto_Produto> foto_produto = new ArrayList<Foto_Produto>() ;

        while(cursor.moveToNext()){
            Foto_Produto modelo = criarFoto_Produto(cursor) ;
            foto_produto.add(modelo);
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

