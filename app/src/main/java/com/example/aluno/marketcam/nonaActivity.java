package com.example.aluno.marketcam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

public class nonaActivity extends AppCompatActivity implements View.OnClickListener{
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
}
