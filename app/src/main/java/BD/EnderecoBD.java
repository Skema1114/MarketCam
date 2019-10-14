package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Endereco;
import interacao.Usuario_Lista_Produto;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class EnderecoBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public EnderecoBD(Context context) {
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


    private Endereco criarEndereco(Cursor cursor){
        Endereco endereco = new Endereco(
                cursor.getInt(cursor.getColumnIndex(Conecta.Endereco.ID_ENDERECO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Endereco.RUA)),
                cursor.getString(cursor.getColumnIndex(Conecta.Endereco.NUMERO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Endereco.BAIRRO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Endereco.CIDADE)),
                cursor.getString(cursor.getColumnIndex(Conecta.Endereco.ESTADO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Endereco.CEP)));


        return endereco;
    }


    public List<Endereco> ListaEndereco(){
        Cursor cursor = getDataBase().query(Conecta.Endereco.TABELA,
                Conecta.Endereco.COLUNAS, null, null, null, null, null);

        List<Endereco> endereco = new ArrayList<Endereco>();

        while (cursor.moveToNext()) {
            Endereco modelo = criarEndereco(cursor);
            endereco.add(modelo);
        }
        cursor.close();
        return endereco;
    }


    public long salvarEndereco(Endereco endereco) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Endereco.RUA, endereco.getRua());
        valores.put(Conecta.Endereco.NUMERO, endereco.getNumero());
        valores.put(Conecta.Endereco.BAIRRO, endereco.getBairro());
        valores.put(Conecta.Endereco.CIDADE, endereco.getCidade());
        valores.put(Conecta.Endereco.ESTADO, endereco.getEstado());
        valores.put(Conecta.Endereco.CEP, endereco.getCep());

        if (endereco.getId_endereco() != null) {
            return sqLiteDatabase.update(Conecta.Endereco.TABELA, valores, "id_endereco = ?",
                    new String[]{endereco.getId_endereco().toString()}
            );
        }
        return getDataBase().insert(Conecta.Endereco.TABELA, null, valores);
    }


    public boolean removerEndereco(int id) {
        return getDataBase().delete(Conecta.Endereco.TABELA, "id_endereco = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Endereco buscarEndereco(int id) {
        Cursor cursor = getDataBase().query(Conecta.Endereco.TABELA, Conecta.Endereco.COLUNAS, "id_endereco = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Endereco> endereco = new ArrayList<Endereco>() ;

        while(cursor.moveToNext()){
            Endereco modelo = criarEndereco(cursor) ;
            endereco.add(modelo);
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
