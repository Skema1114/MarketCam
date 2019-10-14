package com.example.aluno.marketcam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class decimaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnUsuariosT10;
    private Button btnProdutosT10;
    private Button btnEnderecosT10;
    private Button btnComprasT10;
    private Button btnListasComprasT10;
    private Button btnCartõesCreditoT10;
    private Toolbar toolbarT10;
    private TextView textComprasT10;
    private ListView listComprasT10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decima);

        /*findViewById*/
        /*findViewById dos Button*/
        btnUsuariosT10 = (Button) findViewById(R.id.btnUsuariosT10);
        btnProdutosT10 = (Button) findViewById(R.id.btnProdutosT10);
        btnEnderecosT10 = (Button) findViewById(R.id.btnEnderecosT10);
        btnComprasT10 = (Button) findViewById(R.id.btnComprasT10);
        btnListasComprasT10 = (Button) findViewById(R.id.btnListasComprasT10);
        btnCartõesCreditoT10 = (Button) findViewById(R.id.btnCartõesCreditoT10);

        /*findViewById do Toolbar*/
        toolbarT10 = (Toolbar) findViewById(R.id.toolbarT10);

        /*findViewById do TextView*/
        textComprasT10 = (TextView) findViewById(R.id.textComprasT10);

        /*findViewById do ListView*/
        listComprasT10 = (ListView) findViewById(R.id.listComprasT10);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnUsuariosT10.setOnClickListener(this);
        btnProdutosT10.setOnClickListener(this);
        btnEnderecosT10.setOnClickListener(this);
        btnComprasT10.setOnClickListener(this);
        btnListasComprasT10.setOnClickListener(this);
        btnCartõesCreditoT10.setOnClickListener(this);

        /*setOnClickListener do ListView*/
        //listComprasT10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (btnUsuariosT10.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
        }

        if (btnProdutosT10.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
        }

        if (btnEnderecosT10.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
        }

        if (btnComprasT10.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
        }

        if (btnListasComprasT10.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
        }

        if (btnCartõesCreditoT10.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
        }

    }
}
