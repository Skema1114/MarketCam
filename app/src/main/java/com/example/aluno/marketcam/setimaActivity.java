package com.example.aluno.marketcam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class setimaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnUsuariosT7;
    private Button btnProdutosT7;
    private Button btnEnderecosT7;
    private Button btnComprasT7;
    private Button btnListasComprasT7;
    private Button btnCartõesCreditoT7;
    private Toolbar toolbarT7;
    private TextView textUsuariosT7;
    private ListView listUsuariosT7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setima);

        /*findViewById*/
        /*findViewById dos Button*/
        btnUsuariosT7 = (Button) findViewById(R.id.btnUsuariosT7);
        btnProdutosT7 = (Button) findViewById(R.id.btnProdutosT7);
        btnEnderecosT7 = (Button) findViewById(R.id.btnEnderecosT7);
        btnComprasT7 = (Button) findViewById(R.id.btnComprasT7);
        btnListasComprasT7 = (Button) findViewById(R.id.btnListasComprasT7);
        btnCartõesCreditoT7 = (Button) findViewById(R.id.btnCartõesCreditoT7);

        /*findViewById do Toolbar*/
        toolbarT7 = (Toolbar) findViewById(R.id.toolbarT7);

        /*findViewById do TextView*/
        textUsuariosT7 = (TextView) findViewById(R.id.textUsuariosT7);

        /*findViewById do ListView*/
        listUsuariosT7 = (ListView) findViewById(R.id.listUsuariosT7);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnUsuariosT7.setOnClickListener(this);
        btnProdutosT7.setOnClickListener(this);
        btnEnderecosT7.setOnClickListener(this);
        btnComprasT7.setOnClickListener(this);
        btnListasComprasT7.setOnClickListener(this);
        btnCartõesCreditoT7.setOnClickListener(this);

        /*setOnClickListener do ListView*/
        //listUsuariosT7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (btnUsuariosT7.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
        }

        if (btnProdutosT7.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
        }

        if (btnEnderecosT7.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
        }

        if (btnComprasT7.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
        }

        if (btnListasComprasT7.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
        }

        if (btnCartõesCreditoT7.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
        }

    }
}
