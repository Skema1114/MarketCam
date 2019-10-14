package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Carrinho;
import interacao.Cartao_Credito;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class CarrinhoBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public CarrinhoBD(Context context) {
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


    private Carrinho criarCarrinho(Cursor cursor){
        Carrinho carrinho = new Carrinho(
                cursor.getInt(cursor.getColumnIndex(Conecta.Carrinho.ID_CARRINHO)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Carrinho.USUARIO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Carrinho.PRODUTO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Carrinho.QUANTIDADE)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Carrinho.VALOR_TOTAL)));


        return carrinho;
    }


    public List<Carrinho> ListaCarrinho(){
        Cursor cursor = getDataBase().query(Conecta.Carrinho.TABELA,
                Conecta.Carrinho.COLUNAS, null, null, null, null, null);

        List<Carrinho> carrinho = new ArrayList<Carrinho>();

        while (cursor.moveToNext()) {
            Carrinho modelo = criarCarrinho(cursor);
            carrinho.add(modelo);
        }
        cursor.close();
        return carrinho;
    }


    public long salvarCarrinho(Carrinho carrinho) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Carrinho.USUARIO_ID, carrinho.getUsuario_id());
        valores.put(Conecta.Carrinho.PRODUTO_ID, carrinho.getProduto_id());
        valores.put(Conecta.Carrinho.QUANTIDADE, carrinho.getQuantidade());
        valores.put(Conecta.Carrinho.VALOR_TOTAL, carrinho.getValor_total());

        if (carrinho.getId_carrinho() != null) {
            return sqLiteDatabase.update(Conecta.Carrinho.TABELA, valores, "id_carrinho = ?",
                    new String[]{carrinho.getId_carrinho().toString()}
            );
        }
        return getDataBase().insert(Conecta.Carrinho.TABELA, null, valores);
    }


    public boolean removerCarrinho(int id) {
        return getDataBase().delete(Conecta.Carrinho.TABELA, "id_carrinho = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Carrinho buscarCarrinho(int id) {
        Cursor cursor = getDataBase().query(Conecta.Carrinho.TABELA, Conecta.Carrinho.COLUNAS, "id_carrinho = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Carrinho> carrinho = new ArrayList<Carrinho>() ;

        while(cursor.moveToNext()){
            Carrinho modelo = criarCarrinho(cursor) ;
            carrinho.add(modelo);
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

