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

import Adapter.EnderecoAdapter;
import Adapter.ProdutoAdapter;
import BD.EnderecoBD;
import BD.ProdutoBD;
import interacao.Endereco;
import interacao.Produto;
import util.Mensagem;

public class nonaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, DialogInterface.OnClickListener{
    private Button btnUsuariosT9;
    private Button btnProdutosT9;
    private Button btnEnderecosT9;
    private Button btnComprasT9;
    private Button btnListasComprasT9;
    private Button btnCartõesCreditoT9;
    private Toolbar toolbarT9;
    private TextView textEnderecosT9;
    private ListView listEnderecosT9;

    /*Adapter*/
    private ListView lista;
    private List<Endereco> enderecoList;
    private EnderecoAdapter enderecoAdapter;
    private EnderecoBD enderecoBD;

    /*REFERENTE AO "MENU", EDITAR, EXCLUIR*/
    private AlertDialog alertDialog;
    private AlertDialog  alertConfirmacao;
    private int idPosicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nona);

        /*findViewById*/
        /*findViewById dos Button*/
        btnUsuariosT9 = (Button) findViewById(R.id.btnUsuariosT9);
        btnProdutosT9 = (Button) findViewById(R.id.btnProdutosT9);
        btnEnderecosT9 = (Button) findViewById(R.id.btnEnderecosT9);
        btnComprasT9 = (Button) findViewById(R.id.btnComprasT9);
        btnListasComprasT9 = (Button) findViewById(R.id.btnListasComprasT9);
        btnCartõesCreditoT9 = (Button) findViewById(R.id.btnCartõesCreditoT9);

        /*findViewById do Toolbar*/
        toolbarT9 = (Toolbar) findViewById(R.id.toolbarT9);

        /*findViewById do TextView*/
        textEnderecosT9 = (TextView) findViewById(R.id.textEnderecosT9);

        /*findViewById do ListView*/
        listEnderecosT9 = (ListView) findViewById(R.id.listEnderecosT9);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnUsuariosT9.setOnClickListener(this);
        btnProdutosT9.setOnClickListener(this);
        btnEnderecosT9.setOnClickListener(this);
        btnComprasT9.setOnClickListener(this);
        btnListasComprasT9.setOnClickListener(this);
        btnCartõesCreditoT9.setOnClickListener(this);

        /*setOnClickListener do ListView*/
        //listEnderecosT9.setOnClickListener(this);


        /*Adapter*/
        enderecoBD =  new EnderecoBD(this);
        enderecoList = enderecoBD.ListaEndereco();
        enderecoAdapter = new EnderecoAdapter(this, enderecoList);

        lista = (ListView) findViewById(R.id.listEnderecosT9);
        lista.setAdapter(enderecoAdapter);
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

        enderecoBD =  new EnderecoBD(this) ;
        enderecoList = enderecoBD.ListaEndereco() ;
        enderecoAdapter = new EnderecoAdapter(this , enderecoList) ;
        lista = (ListView) findViewById(R.id.listEnderecosT9);
        lista.setAdapter(enderecoAdapter);
        lista.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (btnUsuariosT9.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnProdutosT9.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnEnderecosT9.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnComprasT9.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnListasComprasT9.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnCartõesCreditoT9.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = enderecoList.get(idPosicao).getId_endereco();

        switch(which){
            case 0:
                Intent intent = new Intent(this, quintaActivity.class);
                intent.putExtra("ID_ENDERECO", id);
                startActivity(intent);
                finish();
                break;

            case 1:
                alertConfirmacao.show();
                break;

            case DialogInterface.BUTTON_POSITIVE:
                enderecoList.remove(idPosicao);
                enderecoBD.removerEndereco(id);
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
