package com.example.aluno.marketcam;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Adapter.ProdutoAdapter;
import Adapter.UsuarioAdapter;
import BD.ProdutoBD;
import BD.UsuarioBD;
import interacao.Produto;
import interacao.Usuario;
import util.Mensagem;

public class oitavaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, DialogInterface.OnClickListener{
    private Button btnUsuariosT8;
    private Button btnProdutosT8;
    private Button btnEnderecosT8;
    private Button btnComprasT8;
    private Button btnListasComprasT8;
    private Button btnCartõesCreditoT8;
    private Toolbar toolbarT8;
    private TextView textProdutosT8;
    private ListView listProdutosT8;

    /*Adapter*/
    private ListView lista;
    private List<Produto> produtoList;
    private ProdutoAdapter produtoAdapter;
    private ProdutoBD produtoBD;

    /*REFERENTE AO "MENU", EDITAR, EXCLUIR*/
    private AlertDialog alertDialog;
    private AlertDialog  alertConfirmacao;
    private int idPosicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oitava);

        /*findViewById*/
        /*findViewById dos Button*/
        btnUsuariosT8 = (Button) findViewById(R.id.btnUsuariosT8);
        btnProdutosT8 = (Button) findViewById(R.id.btnProdutosT8);
        btnEnderecosT8 = (Button) findViewById(R.id.btnEnderecosT8);
        btnComprasT8 = (Button) findViewById(R.id.btnComprasT8);
        btnListasComprasT8 = (Button) findViewById(R.id.btnListasComprasT8);
        btnCartõesCreditoT8 = (Button) findViewById(R.id.btnCartõesCreditoT8);

        /*findViewById do Toolbar*/
        toolbarT8 = (Toolbar) findViewById(R.id.toolbarT8);

        /*findViewById do TextView*/
        textProdutosT8 = (TextView) findViewById(R.id.textProdutosT8);

        /*findViewById do ListView*/
        listProdutosT8 = (ListView) findViewById(R.id.listProdutosT8);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnUsuariosT8.setOnClickListener(this);
        btnProdutosT8.setOnClickListener(this);
        btnEnderecosT8.setOnClickListener(this);
        btnComprasT8.setOnClickListener(this);
        btnListasComprasT8.setOnClickListener(this);
        btnCartõesCreditoT8.setOnClickListener(this);

        /*setOnClickListener do ListView*/
        //listProdutosT8.setOnClickListener(this);


        /*Adapter*/
        produtoBD =  new ProdutoBD(this);
        produtoList = produtoBD.ListaProduto();
        produtoAdapter = new ProdutoAdapter(this, produtoList);

        lista = (ListView) findViewById(R.id.listProdutosT8);
        lista.setAdapter(produtoAdapter);
        //lista.setOnItemClickListener(this);


        /*REFERENTE AO "MENU", EDITAR, EXCLUIR*/
        alertDialog = Mensagem.criarAlertDialog(this);
        alertConfirmacao = Mensagem.CriarDialogConfirmacao(this, "Sair",
                "Deseja Realmente Sair?", R.drawable.sair,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        produtoBD =  new ProdutoBD(this) ;
        produtoList = produtoBD.ListaProduto() ;
        produtoAdapter = new ProdutoAdapter(this , produtoList) ;
        lista = (ListView) findViewById(R.id.listProdutosT8);
        lista.setAdapter(produtoAdapter);
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (btnUsuariosT8.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnProdutosT8.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnEnderecosT8.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnComprasT8.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnListasComprasT8.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnCartõesCreditoT8.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = produtoList.get(idPosicao).getId_produto();

        switch(which){
            case 0:
                Intent intent = new Intent(this, quintaActivity.class);
                intent.putExtra("ID_PRODUTO", id);
                startActivity(intent);
                finish();
                break;

            case 1:
                alertConfirmacao.show();
                break;

            case DialogInterface.BUTTON_POSITIVE:
                produtoList.remove(idPosicao);
                produtoBD.removerProduto(id);
                lista.invalidateViews();
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                alertConfirmacao.dismiss();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idPosicao = position;
        alertDialog.show();
    }
}
