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

import Adapter.CompraAdapter;
import Adapter.ListaAdapter;
import BD.CompraBD;
import BD.ListaBD;
import interacao.Lista;

public class decimaPrimeiraActivity extends AppCompatActivity implements View.OnClickListener{
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
    }

    @Override
    public void onClick(View v) {
        if (btnUsuariosT11.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
        }

        if (btnProdutosT11.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
        }

        if (btnEnderecosT11.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
        }

        if (btnComprasT11.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
        }

        if (btnListasComprasT11.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
        }

        if (btnCartõesCreditoT11.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
        }

    }
}
