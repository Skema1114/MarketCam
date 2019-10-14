package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Cartao_Credito;
import interacao.Usuario_Lista_Produto;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class Cartao_CreditoBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public Cartao_CreditoBD(Context context) {
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


    private Cartao_Credito criarCartao_Credito(Cursor cursor){
        Cartao_Credito cartao_credito = new Cartao_Credito(
                cursor.getInt(cursor.getColumnIndex(Conecta.Cartao_Credito.ID_CARTAO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Cartao_Credito.TITULAR_CARTAO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Cartao_Credito.NUMERO_CARTAO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Cartao_Credito.VALIDADE_CARTAO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Cartao_Credito.CODIGO_CARTAO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Cartao_Credito.SALVAR_CODIGO_CARTAO)));


        return cartao_credito;
    }


    public List<Cartao_Credito> ListaCartao_Credito(){
        Cursor cursor = getDataBase().query(Conecta.Cartao_Credito.TABELA,
                Conecta.Cartao_Credito.COLUNAS, null, null, null, null, null);

        List<Cartao_Credito> cartao_credito = new ArrayList<Cartao_Credito>();

        while (cursor.moveToNext()) {
            Cartao_Credito modelo = criarCartao_Credito(cursor);
            cartao_credito.add(modelo);
        }
        cursor.close();
        return cartao_credito;
    }


    public long salvarCartao_Credito(Cartao_Credito cartao_credito) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Cartao_Credito.TITULAR_CARTAO, cartao_credito.getTitular_cartao());
        valores.put(Conecta.Cartao_Credito.NUMERO_CARTAO, cartao_credito.getNumero_cartao());
        valores.put(Conecta.Cartao_Credito.VALIDADE_CARTAO, cartao_credito.getValidade_cartao());
        valores.put(Conecta.Cartao_Credito.CODIGO_CARTAO, cartao_credito.getCodigo_cartao());
        valores.put(Conecta.Cartao_Credito.SALVAR_CODIGO_CARTAO, cartao_credito.getSalvar_codigo_cartao());

        if (cartao_credito.getId_cartao() != null) {
            return sqLiteDatabase.update(Conecta.Cartao_Credito.TABELA, valores, "id_cartao = ?",
                    new String[]{cartao_credito.getId_cartao().toString()}
            );
        }
        return getDataBase().insert(Conecta.Cartao_Credito.TABELA, null, valores);
    }


    public boolean removerCartao_Credito(int id) {
        return getDataBase().delete(Conecta.Cartao_Credito.TABELA, "id_cartao = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Cartao_Credito buscarCartao_Credito(int id) {
        Cursor cursor = getDataBase().query(Conecta.Cartao_Credito.TABELA, Conecta.Cartao_Credito.COLUNAS, "id_cartao = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Cartao_Credito> cartao_credito = new ArrayList<Cartao_Credito>() ;

        while(cursor.moveToNext()){
            Cartao_Credito modelo = criarCartao_Credito(cursor) ;
            cartao_credito.add(modelo);
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
