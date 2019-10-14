package BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;

/**
 * Created by Rafael Martins on 29/11/2016 14:54.
 */

/*PRIMEIRO PASSO FOI CRIAR O BANCO DE DADOS, CRIAR AS TABELAS E JÁ INSERIR DADOS DE ADMINISTRADOR*/
/*SEGUNDO PASSO FOI DEFINIR O METODO PARA PEGAR A HORA DO CELULAR E ADICIONAR NO CAMPO "criado" DOS PERFIS QUE JÁ SERÃ CRIADOS*/
/* ---------------- COMEÇO DA EDIÇÃO DA AULA DIA 29/11/2016 14:54 ---------------- */
public class Conecta extends SQLiteOpenHelper{
    private final static String BANCO_DE_DADOS = "MarketCam";
    private final static int VERSAO = 1;


    public Conecta(Context context){
        super(context, BANCO_DE_DADOS, null, VERSAO);

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*CODIGO DE CRIAÇÃO DA TABELA "Cartao_Credito" NO SQLite*/
        String sql = "CREATE TABLE IF NOT EXISTS Cartao_Credito (" +
                        "id_cartao INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                        "titular_cartao TEXT(40) NOT NULL," +
                        "numero_cartao TEXT(16) NOT NULL UNIQUE," +
                        "validade_cartao TEXT(8) NOT NULL," +
                        "codigo_cartao TEXT(3) NULL," +
                        "salvar_codigo_cartao TEXT(3) NOT NULL DEFAULT 'nao'" +
                    ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Cartao_Credito" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Endereco" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Endereco (" +
                    "id_endereco INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "rua TEXT(45) NULL," +
                    "numero TEXT(10) NULL," +
                    "bairro TEXT(25) NULL," +
                    "cidade TEXT(40) NOT NULL," +
                    "estado TEXT(25) NOT NULL," +
                    "cep TEXT(10) NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Endereco" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Foto_Usuario" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Foto_Usuario (" +
                    "id_foto_usuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "foto MEDIUMBLOB NOT NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Foto_Usuario" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Nivel_Acesso" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Nivel_Acesso (" +
                    "id_nivel_acesso INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "nome TEXT(50) NOT NULL," +
                    "criado DATETIME NOT NULL," +
                    "modificado DATETIME NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Nivel_Acesso" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Usuario" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Usuario (" +
                    "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "foto_usuario_id INTEGER NOT NULL," +
                    "cartao_id INTEGER NULL UNIQUE," +
                    "endereco_id INTEGER NOT NULL," +
                    "nivel_acesso_id INTEGER NOT NULL," +
                    "nome TEXT(50) NOT NULL," +
                    "data_nascimento DATE NOT NULL," +
                    "telefone TEXT(15) NULL," +
                    "sexo TEXT(1) NOT NULL," +
                    "email TEXT(64) NOT NULL UNIQUE," +
                    "senha TEXT(64) NOT NULL," +
                    "criado DATETIME NOT NULL," +
                    "modificado DATETIME NULL," +
                    "perfil_usuario TEXT(13) NOT NULL DEFAULT 'cliente'," +
                    "status_usuario TEXT(7) NOT NULL DEFAULT 'ativo'" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Usuario" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Foto_Produto" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Foto_Produto (" +
                    "id_foto_produto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "foto MEDIUMBLOB NOT NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Foto_Produto" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Produto" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Produto (" +
                    "id_produto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "foto_produto_id INTEGER NOT NULL," +
                    "codigo_barras INTEGER NOT NULL," +
                    "nome TEXT(40) NOT NULL," +
                    "valor DOUBLE NOT NULL," +
                    "lote TEXT(10) NULL," +
                    "descricao TEXT(500) NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Produto" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Carrinho" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Carrinho (" +
                    "id_carrinho INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "usuario_id INTEGER NOT NULL," +
                    "produto_id INTEGER NOT NULL," +
                    "quantidade INTEGER NOT NULL," +
                    "valor_total DOUBLE NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Carrinho" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Foto_Produto" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Compra (" +
                    "id_compra INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "carrinho_id INTEGER NOT NULL," +
                    "data DATE NOT NULL,hora TIME NOT NULL," +
                    "tag TEXT(20) NULL," +
                    "valor_total DOUBLE NOT NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Foto_Produto" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Lista" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Lista (" +
                    "id_lista INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "nome TEXT(45) NOT NULL," +
                    "data_hora DATETIME(6) NULL," +
                    "valor_total DOUBLE NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Lista" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE CRIAÇÃO DA TABELA "Usuario_Lista_Produto" NO SQLite*/
        sql = "CREATE TABLE IF NOT EXISTS Usuario_Lista_Produto (" +
                    "id_usuario_lista_produto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                    "produto_id INTEGER NOT NULL," +
                    "usuario_id INTEGER NOT NULL," +
                    "lista_id INTEGER NOT NULL," +
                    "quantidade INTEGER NOT NULL," +
                    "valor_total DOUBLE NULL" +
                ")";

        /*EXECUTA O CODIGO E CRIA A TABELA DE "Usuario_Lista_Produto" NO SQLite*/
        db.execSQL(sql);


        /* ---------------- INICIO DA EDIÇÃO DA AULA DIA 30/11/2016 13:42 ---------------- */
        /* CODIGO PARA INSERIR A DATA ATUAL DO TELEFONE EM ALGUM CAMPO PRÉ-DEFINIDO DO BANCO DE DADOSA*/
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(date);
        /* FOI ADICIONADO A STRING "dateString" EM TODOS OS CAMPOS "criado" ABAIXO, PARA QUE QUANDO ESES PERFIS FOREM CRIADOS PEGUEM A DATA ATUAL DO CELULAR*/
        /* ---------------- FIM DA EDIÇÃO -_-DESSA PAGINA-_- DA AULA DIA 30/11/2016 13:42 ---------------- */


        /*-----------------------------------------------------------------------------------------*/

        /*INSERINDO DADOS NAS TABELAS*/
        /*CODIGO DE INSERÇÃO PARAA TABELA "Foto_Usuario"*/
        sql = "INSERT INTO Foto_Usuario (id_foto_usuario, foto) " +
                "VALUES (1, 'nomeDaFoto.png')";

        /*ENVIANDO DADOS PARA A TABELA "Foto_Usuario" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE INSERÇÃO PARAA TABELA "Endereco"*/
        sql = "INSERT INTO Endereco (id_endereco, rua, numero, bairro, cidade, estado, cep)" +
                "VALUES (1, 'Cristovão Colombo', '2390', 'Passo', 'São Borja', 'RS', '97670000')";

        /*ENVIANDO DADOS PARA A TABELA "Endereco" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE INSERÇÃO PARAA TABELA "Nivel_Acesso"*/
        sql = "INSERT INTO Nivel_Acesso (id_nivel_acesso, nome, criado, modificado)" +
                "VALUES  (1, 'administrador', '"+dateString+"', NULL)";

        /*ENVIANDO DADOS PARA A TABELA "Nivel_Acesso" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        sql = "INSERT INTO Nivel_Acesso (id_nivel_acesso, nome, criado, modificado)" +
                "VALUES  (2, 'mercado', '"+dateString+"', NULL)";

        /*ENVIANDO DADOS PARA A TABELA "Nivel_Acesso" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        sql = "INSERT INTO Nivel_Acesso (id_nivel_acesso, nome, criado, modificado)" +
                "VALUES  (3, 'cliente', '"+dateString+"', NULL)";

        /*ENVIANDO DADOS PARA A TABELA "Nivel_Acesso" NO SQLite*/
        db.execSQL(sql);


        /*-----------------------------------------------------------------------------------------*/

        /*CODIGO DE INSERÇÃO PARAA TABELA "Usuario"*/
        sql = "INSERT INTO Usuario (id_usuario, foto_usuario_id, cartao_id, endereco_id, nivel_acesso_id, nome, data_nascimento, telefone, sexo, email, senha, criado, modificado, perfil_usuario, status_usuario)" +
                "VALUES (1, 1, null, 1, 1, 'Rafael Aranda Martins', '1997-04-10', '5591711114', 'M', 'skema1114@hotmail.com', '$ystem@dmin1114', '"+dateString+"', null, 'administrador', 'ativo')";

        /*ENVIANDO DADOS PARA A TABELA "Usuario" NO SQLite*/
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public static class Cartao_Credito{
        public static final String TABELA = "Cartao_Credito";
        public static final String ID_CARTAO = "id_cartao";
        public static final String TITULAR_CARTAO = "titular_cartao";
        public static final String NUMERO_CARTAO = "numero_cartao";
        public static final String VALIDADE_CARTAO = "validade_cartao";
        public static final String CODIGO_CARTAO = "codigo_cartao";
        public static final String SALVAR_CODIGO_CARTAO = "salvar_codigo_cartao";


        public  final static String [] COLUNAS  = new String[]{
                ID_CARTAO, TITULAR_CARTAO, NUMERO_CARTAO, VALIDADE_CARTAO, CODIGO_CARTAO, SALVAR_CODIGO_CARTAO

        };
    }


    public static class Endereco{
        public static final String TABELA = "Endereco";
        public static final String ID_ENDERECO = "id_endereco";
        public static final String RUA = "rua";
        public static final String NUMERO = "numero";
        public static final String BAIRRO = "bairro";
        public static final String CIDADE = "cidade";
        public static final String ESTADO = "estado";
        public static final String CEP = "cep";


        public  final static String [] COLUNAS  = new String[]{
                ID_ENDERECO, RUA, NUMERO, BAIRRO, CIDADE, ESTADO, CEP

        };
    }


    public static class Foto_Usuario{
        public static final String TABELA = "Foto_Usuario";
        public static final String ID_FOTO_USUARIO = "id_foto_usuario";
        public static final String FOTO = "foto";


        public  final static String [] COLUNAS  = new String[]{
                ID_FOTO_USUARIO, FOTO

        };
    }


    public static class Nivel_Acesso{
        public static final String TABELA = "Nivel_Acesso";
        public static final String ID_NIVEL_ACESSO = "id_nivel_acesso";
        public static final String NOME = "nome";
        public static final String CRIADO = "criado";
        public static final String MODIFICADO = "modificado";


        public  final static String [] COLUNAS  = new String[]{
                ID_NIVEL_ACESSO, NOME, CRIADO, MODIFICADO

        };
    }


    public static class Usuario{
        public static final String TABELA = "Usuario";
        public static final String ID_USUARIO = "id_usuario";
        public static final String FOTO_USUARIO_ID = "foto_usuario_id";
        public static final String CARTAO_ID = "cartao_id";
        public static final String ENDERECO_ID = "endereco_id";
        public static final String NIVEL_ACESSO_ID = "nivel_acesso_id";
        public static final String NOME = "nome";
        public static final String DATA_NASCIMENTO = "data_nascimento";
        public static final String TELEFONE = "telefone";
        public static final String SEXO = "sexo";
        public static final String EMAIL = "email";
        public static final String SENHA = "senha";
        public static final String CRIADO = "criado";
        public static final String MODIFICADO = "modificado";
        public static final String PERFIL_USUARIO = "perfil_usuario";
        public static final String STATUS_USUARIO = "status_usuario";


        public  final static String [] COLUNAS  = new String[]{
                ID_USUARIO, FOTO_USUARIO_ID, CARTAO_ID, ENDERECO_ID, NIVEL_ACESSO_ID, NOME,
                DATA_NASCIMENTO, TELEFONE, SEXO, EMAIL, SENHA, CRIADO, MODIFICADO, PERFIL_USUARIO, STATUS_USUARIO
        };
    }


    public static class Foto_Produto{
        public static final String TABELA = "Foto_Produto";
        public static final String ID_FOTO_PRODUTO = "id_foto_produto";
        public static final String FOTO = "foto";


        public  final static String [] COLUNAS  = new String[]{
                ID_FOTO_PRODUTO, FOTO

        };
    }


    public static class Produto{
        public static final String TABELA = "Produto";
        public static final String ID_PRODUTO = "id_produto";
        public static final String FOTO_PRODUTO_ID = "foto_produto_id";
        public static final String CODIGO_BARRAS = "codigo_barras";
        public static final String NOME = "nome";
        public static final String VALOR = "valor";
        public static final String LOTE = "lote";
        public static final String DESCRICAO = "descricao";


        public  final static String [] COLUNAS  = new String[]{
                ID_PRODUTO, FOTO_PRODUTO_ID, CODIGO_BARRAS, NOME, VALOR, LOTE, DESCRICAO

        };
    }


    public static class Carrinho{
        public static final String TABELA = "Carrinho";
        public static final String ID_CARRINHO = "id_carrinho";
        public static final String USUARIO_ID = "usuario_id";
        public static final String PRODUTO_ID = "produto_id";
        public static final String QUANTIDADE = "quantidade";
        public static final String VALOR_TOTAL = "valor_total";


        public  final static String [] COLUNAS  = new String[]{
                ID_CARRINHO, USUARIO_ID, PRODUTO_ID, QUANTIDADE, VALOR_TOTAL

        };
    }


    public static class Compra{
        public static final String TABELA = "Compra";
        public static final String ID_COMPRA = "id_compra";
        public static final String CARRINHO_ID = "carrinho_id";
        public static final String DATA = "data";
        public static final String HORA = "hora";
        public static final String TAG = "tag";
        public static final String VALOR_TOTAL = "valor_total";


        public  final static String [] COLUNAS  = new String[]{
                ID_COMPRA, CARRINHO_ID, DATA, HORA, TAG, VALOR_TOTAL

        };
    }


    public static class Lista{
        public static final String TABELA = "Lista";
        public static final String ID_LISTA = "id_lista";
        public static final String NOME = "nome";
        public static final String DATA_HORA = "data_hora";
        public static final String VALOR_TOTAL = "valor_total";


        public  final static String [] COLUNAS  = new String[]{
                ID_LISTA, NOME, DATA_HORA, VALOR_TOTAL

        };
    }


    public static class Usuario_Lista_Produto{
        public static final String TABELA = "Usuario_Lista_Produto";
        public static final String ID_USUARIO_LISTA_PRODUTO = "id_usuario_lista_produto";
        public static final String PRODUTO_ID = "produto_id";
        public static final String USUARIO_ID = "usuario_id";
        public static final String LISTA_ID = "lista_id";
        public static final String QUANTIDADE = "quantidade";
        public static final String VALOR_TOTAL = "valor_total";


        public  final static String [] COLUNAS  = new String[]{
                ID_USUARIO_LISTA_PRODUTO, PRODUTO_ID, USUARIO_ID, LISTA_ID, QUANTIDADE, VALOR_TOTAL

        };
    }
}

/* ---------------- FINAL DA EDIÇÃO DA AULA DIA 29/11/2016 17:23 ---------------- */
