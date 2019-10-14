package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Produto;
import interacao.Usuario_Lista_Produto;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class ProdutoBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public ProdutoBD(Context context) {
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


    private Produto criarProduto(Cursor cursor){
        Produto produto = new Produto(
                cursor.getInt(cursor.getColumnIndex(Conecta.Produto.ID_PRODUTO)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Produto.FOTO_PRODUTO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Produto.CODIGO_BARRAS)),
                cursor.getString(cursor.getColumnIndex(Conecta.Produto.NOME)),
                cursor.getDouble(cursor.getColumnIndex(Conecta.Produto.VALOR)),
                cursor.getString(cursor.getColumnIndex(Conecta.Produto.LOTE)),
                cursor.getString(cursor.getColumnIndex(Conecta.Produto.DESCRICAO)));


        return produto;
    }


    public List<Produto> ListaProduto(){
        Cursor cursor = getDataBase().query(Conecta.Produto.TABELA,
                Conecta.Produto.COLUNAS, null, null, null, null, null);

        List<Produto> produto = new ArrayList<Produto>();

        while (cursor.moveToNext()) {
            Produto modelo = criarProduto(cursor);
            produto.add(modelo);
        }
        cursor.close();
        return produto;
    }


    public long salvarProduto(Produto produto) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Produto.FOTO_PRODUTO_ID, produto.getFoto_produto_id());
        valores.put(Conecta.Produto.CODIGO_BARRAS, produto.getCodigo_barras());
        valores.put(Conecta.Produto.NOME, produto.getNome());
        valores.put(Conecta.Produto.VALOR, produto.getValor());
        valores.put(Conecta.Produto.LOTE, produto.getLote());
        valores.put(Conecta.Produto.DESCRICAO, produto.getDescricao());

        if (produto.getId_produto() != null) {
            return sqLiteDatabase.update(Conecta.Produto.TABELA, valores, "id_produto = ?",
                    new String[]{produto.getId_produto().toString()}
            );
        }
        return getDataBase().insert(Conecta.Produto.TABELA, null, valores);
    }


    public boolean removerProduto(int id) {
        return getDataBase().delete(Conecta.Produto.TABELA, "id_produto = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Produto buscarProduto(int id) {
        Cursor cursor = getDataBase().query(Conecta.Produto.TABELA, Conecta.Produto.COLUNAS, "id_produto = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Produto> produto = new ArrayList<Produto>() ;

        while(cursor.moveToNext()){
            Produto modelo = criarProduto(cursor) ;
            produto.add(modelo);
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
