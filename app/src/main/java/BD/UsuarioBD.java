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


    private Usuario criarUsuario(Cursor cursor) {
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
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.CRIADO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.MODIFICADO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.PERFIL_USUARIO)),
                cursor.getString(cursor.getColumnIndex(Conecta.Usuario.STATUS_USUARIO)));
        //ESSES DOIS SÃO DO TIPO DATE


        return usuario;
    }
}

//AQUI FOI PARADA A EDIÇÃO