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
import interacao.Cartao_Credito;
import util.Mensagem;

public class decimaSegundaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, DialogInterface.OnClickListener{
    private Button btnUsuariosT12;
    private Button btnProdutosT12;
    private Button btnEnderecosT12;
    private Button btnComprasT12;
    private Button btnListasComprasT12;
    private Button btnCartõesCreditoT12;
    private Toolbar toolbarT12;
    private TextView textCartoesCreditoT12;
    private ListView listCartoesCreditoT12;

    /*Adapter*/
    private ListView lista;
    private List<Cartao_Credito> cartao_creditoList;
    private Cartao_CreditoAdapter cartao_creditoAdapter;
    private Cartao_CreditoBD cartao_creditoBD;

    /*REFERENTE AO "MENU", EDITAR, EXCLUIR*/
    private AlertDialog alertDialog;
    private AlertDialog alertConfirmacao;
    private int idPosicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decima_segunda);

        /*findViewById*/
        /*findViewById dos Button*/
        btnUsuariosT12 = (Button) findViewById(R.id.btnUsuariosT12);
        btnProdutosT12 = (Button) findViewById(R.id.btnProdutosT12);
        btnEnderecosT12 = (Button) findViewById(R.id.btnEnderecosT12);
        btnComprasT12 = (Button) findViewById(R.id.btnComprasT12);
        btnListasComprasT12 = (Button) findViewById(R.id.btnListasComprasT12);
        btnCartõesCreditoT12 = (Button) findViewById(R.id.btnCartõesCreditoT12);

        /*findViewById do Toolbar*/
        toolbarT12 = (Toolbar) findViewById(R.id.toolbarT12);

        /*findViewById do TextView*/
        textCartoesCreditoT12 = (TextView) findViewById(R.id.textCartoesCreditoT12);

        /*findViewById do ListView*/
        listCartoesCreditoT12 = (ListView) findViewById(R.id.listCartoesCreditoT12);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnUsuariosT12.setOnClickListener(this);
        btnProdutosT12.setOnClickListener(this);
        btnEnderecosT12.setOnClickListener(this);
        btnComprasT12.setOnClickListener(this);
        btnListasComprasT12.setOnClickListener(this);
        btnCartõesCreditoT12.setOnClickListener(this);

        /*setOnClickListener do ListView*/
        //listCartoesCreditoT12.setOnClickListener(this);


        /*Adapter*/
        cartao_creditoBD =  new Cartao_CreditoBD(this);
        cartao_creditoList = cartao_creditoBD.ListaCartao_Credito();
        cartao_creditoAdapter = new Cartao_CreditoAdapter(this, cartao_creditoList);

        lista = (ListView) findViewById(R.id.listCartoesCreditoT12);
        lista.setAdapter(cartao_creditoAdapter);
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

        cartao_creditoBD =  new Cartao_CreditoBD(this) ;
        cartao_creditoList = cartao_creditoBD.ListaCartao_Credito() ;
        cartao_creditoAdapter = new Cartao_CreditoAdapter(this , cartao_creditoList) ;
        lista = (ListView) findViewById(R.id.listComprasT10);
        lista.setAdapter(cartao_creditoAdapter);
        lista.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (btnUsuariosT12.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnProdutosT12.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnEnderecosT12.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnComprasT12.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnListasComprasT12.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnCartõesCreditoT12.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = cartao_creditoList.get(idPosicao).getId_cartao();

        switch(which){
            case 0:
                Intent intent = new Intent(this, quintaActivity.class);
                intent.putExtra("ID_CARTAO_CREDITO", id);
                startActivity(intent);
                finish();
                break;

            case 1:
                alertConfirmacao.show();
                break;

            case DialogInterface.BUTTON_POSITIVE:
                cartao_creditoList.remove(idPosicao);
                cartao_creditoBD.removerCartao_Credito(id);
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
