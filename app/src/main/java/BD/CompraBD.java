package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Compra;
import interacao.Usuario_Lista_Produto;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class CompraBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public CompraBD(Context context) {
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


    private Compra criarCompra(Cursor cursor){
        Compra compra = new Compra(
                cursor.getInt(cursor.getColumnIndex(Conecta.Compra.ID_COMPRA)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Compra.CARRINHO_ID)),
                cursor.getString(cursor.getColumnIndex(Conecta.Compra.DATA)),
                cursor.getString(cursor.getColumnIndex(Conecta.Compra.HORA)),
                cursor.getString(cursor.getColumnIndex(Conecta.Compra.TAG)),
                cursor.getDouble(cursor.getColumnIndex(Conecta.Compra.VALOR_TOTAL)));


        return compra;
    }


    public List<Compra> ListaCompra(){
        Cursor cursor = getDataBase().query(Conecta.Compra.TABELA,
                Conecta.Compra.COLUNAS, null, null, null, null, null);

        List<Compra> compra = new ArrayList<Compra>();

        while (cursor.moveToNext()) {
            Compra modelo = criarCompra(cursor);
            compra.add(modelo);
        }
        cursor.close();
        return compra;
    }


    public long salvarCompra(Compra compra) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Compra.CARRINHO_ID, compra.getCarrinho_id());
        valores.put(Conecta.Compra.DATA, compra.getData());
        valores.put(Conecta.Compra.HORA, compra.getHora());
        valores.put(Conecta.Compra.TAG, compra.getTag());
        valores.put(Conecta.Compra.VALOR_TOTAL, compra.getValor_total());

        if (compra.getId_compra() != null) {
            return sqLiteDatabase.update(Conecta.Compra.TABELA, valores, "id_compra = ?",
                    new String[]{compra.getId_compra().toString()}
            );
        }
        return getDataBase().insert(Conecta.Compra.TABELA, null, valores);
    }


    public boolean removerCompra(int id) {
        return getDataBase().delete(Conecta.Compra.TABELA, "id_compra = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Compra buscarCompra(int id) {
        Cursor cursor = getDataBase().query(Conecta.Compra.TABELA, Conecta.Compra.COLUNAS, "id_compra = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Compra> compra = new ArrayList<Compra>() ;

        while(cursor.moveToNext()){
            Compra modelo = criarCompra(cursor) ;
            compra.add(modelo);
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
