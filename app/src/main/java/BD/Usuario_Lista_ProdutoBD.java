package BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import interacao.Usuario;
import interacao.Usuario_Lista_Produto;

/**
 * Created by Rafael Martins on 02/12/2016.
 */

public class Usuario_Lista_ProdutoBD {
    private Conecta dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public Usuario_Lista_ProdutoBD(Context context) {
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


    private Usuario_Lista_Produto criarUsuario_Lista_Produto(Cursor cursor){
        Usuario_Lista_Produto usuario_lista_produto = new Usuario_Lista_Produto(
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario_Lista_Produto.ID_USUARIO_LISTA_PRODUTO)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario_Lista_Produto.PRODUTO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario_Lista_Produto.USUARIO_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario_Lista_Produto.LISTA_ID)),
                cursor.getInt(cursor.getColumnIndex(Conecta.Usuario_Lista_Produto.QUANTIDADE)),
                cursor.getDouble(cursor.getColumnIndex(Conecta.Usuario_Lista_Produto.VALOR_TOTAL)));


        return usuario_lista_produto;
    }


    public List<Usuario_Lista_Produto> ListaUsuario_Lista_Produto(){
        Cursor cursor = getDataBase().query(Conecta.Usuario_Lista_Produto.TABELA,
                Conecta.Usuario_Lista_Produto.COLUNAS, null, null, null, null, null);

        List<Usuario_Lista_Produto> usuario_lista_produto = new ArrayList<Usuario_Lista_Produto>();

        while (cursor.moveToNext()) {
            Usuario_Lista_Produto modelo = criarUsuario_Lista_Produto(cursor);
            usuario_lista_produto.add(modelo);
        }
        cursor.close();
        return usuario_lista_produto;
    }


    public long salvarUsuario_Lista_Produto(Usuario_Lista_Produto usuario_lista_produto) {
        ContentValues valores = new ContentValues();

        valores.put(Conecta.Usuario_Lista_Produto.PRODUTO_ID, usuario_lista_produto.getProduto_id());
        valores.put(Conecta.Usuario_Lista_Produto.USUARIO_ID, usuario_lista_produto.getUsuario_id());
        valores.put(Conecta.Usuario_Lista_Produto.LISTA_ID, usuario_lista_produto.getLista_id());
        valores.put(Conecta.Usuario_Lista_Produto.QUANTIDADE, usuario_lista_produto.getQuantidade());
        valores.put(Conecta.Usuario_Lista_Produto.VALOR_TOTAL, usuario_lista_produto.getValor_total());

        if (usuario_lista_produto.getId_usuario_lista_produto() != null) {
            return sqLiteDatabase.update(Conecta.Usuario_Lista_Produto.TABELA, valores, "id_usuario_lista_produto = ?",
                    new String[]{usuario_lista_produto.getId_usuario_lista_produto().toString()}
            );
        }
        return getDataBase().insert(Conecta.Usuario_Lista_Produto.TABELA, null, valores);
    }


    public boolean removerUsuario_Lista_Produto(int id) {
        return getDataBase().delete(Conecta.Usuario_Lista_Produto.TABELA, "id_usuario_lista_produto = ?", new String[]{(Integer.toString(id))})>0;
    }


    public Usuario_Lista_Produto buscarUsuario_Lista_Produto(int id) {
        Cursor cursor = getDataBase().query(Conecta.Usuario_Lista_Produto.TABELA, Conecta.Usuario_Lista_Produto.COLUNAS, "id_usuario_lista_produto = ?", new String[]{Integer.toString(id)}, null, null, null);

        List<Usuario_Lista_Produto> usuario_lista_produto = new ArrayList<Usuario_Lista_Produto>() ;

        while(cursor.moveToNext()){
            Usuario_Lista_Produto modelo = criarUsuario_Lista_Produto(cursor) ;
            usuario_lista_produto.add(modelo);
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
