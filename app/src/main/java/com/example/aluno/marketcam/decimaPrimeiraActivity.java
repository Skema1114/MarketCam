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

import Adapter.Cartao_CreditoAdapter;
import Adapter.CompraAdapter;
import Adapter.ListaAdapter;
import BD.Cartao_CreditoBD;
import BD.CompraBD;
import BD.ListaBD;
import interacao.Lista;
import util.Mensagem;

public class decimaPrimeiraActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, DialogInterface.OnClickListener{
    private Button btnUsuariosT11;
    private Button btnProdutosT11;
    private Button btnEnderecosT11;
    private Button btnComprasT11;
    private Button btnListasComprasT11;
    private Button btnCartõesCreditoT11;
    private Toolbar toolbarT11;
    private TextView textListasComprasT11;
    private ListView listListasComprasT11;

    /*Adapter*/
    private ListView lista;
    private List<Lista> listaList;
    private ListaAdapter listaAdapter;
    private ListaBD listaBD;

    /*REFERENTE AO "MENU", EDITAR, EXCLUIR*/
    private AlertDialog alertDialog;
    private AlertDialog alertConfirmacao;
    private int idPosicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decima_primeira);

        /*findViewById*/
        /*findViewById dos Button*/
        btnUsuariosT11 = (Button) findViewById(R.id.btnUsuariosT11);
        btnProdutosT11 = (Button) findViewById(R.id.btnProdutosT11);
        btnEnderecosT11 = (Button) findViewById(R.id.btnEnderecosT11);
        btnComprasT11 = (Button) findViewById(R.id.btnComprasT11);
        btnListasComprasT11 = (Button) findViewById(R.id.btnListasComprasT11);
        btnCartõesCreditoT11 = (Button) findViewById(R.id.btnCartõesCreditoT11);

        /*findViewById do Toolbar*/
        toolbarT11 = (Toolbar) findViewById(R.id.toolbarT11);

        /*findViewById do TextView*/
        textListasComprasT11 = (TextView) findViewById(R.id.textListasComprasT11);

        /*findViewById do ListView*/
        listListasComprasT11 = (ListView) findViewById(R.id.listListasComprasT11);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnUsuariosT11.setOnClickListener(this);
        btnProdutosT11.setOnClickListener(this);
        btnEnderecosT11.setOnClickListener(this);
        btnComprasT11.setOnClickListener(this);
        btnListasComprasT11.setOnClickListener(this);
        btnCartõesCreditoT11.setOnClickListener(this);

        /*setOnClickListener do ListView*/
        //listListasComprasT11.setOnClickListener(this);


        /*Adapter*/
        listaBD =  new ListaBD(this);
        listaList = listaBD.ListaLista();
        listaAdapter = new ListaAdapter(this, listaList);

        lista = (ListView) findViewById(R.id.listListasComprasT11);
        lista.setAdapter(listaAdapter);
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

        listaBD =  new ListaBD(this) ;
        listaList = listaBD.ListaLista() ;
        listaAdapter = new ListaAdapter(this , listaList) ;
        lista = (ListView) findViewById(R.id.listListasComprasT11);
        lista.setAdapter(listaAdapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (btnUsuariosT11.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnProdutosT11.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnEnderecosT11.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnComprasT11.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnListasComprasT11.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnCartõesCreditoT11.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = listaList.get(idPosicao).getId_lista();

        switch(which){
            case 0:
                Intent intent = new Intent(this, quintaActivity.class);
                intent.putExtra("ID_LISTA", id);
                startActivity(intent);
                finish();
                break;

            case 1:
                alertConfirmacao.show();
                break;

            case DialogInterface.BUTTON_POSITIVE:
                listaList.remove(idPosicao);
                listaBD.removerLista(id);
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
