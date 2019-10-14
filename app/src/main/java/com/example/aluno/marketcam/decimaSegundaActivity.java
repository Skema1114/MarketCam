package com.example.aluno.marketcam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class decimaSegundaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnUsuariosT12;
    private Button btnProdutosT12;
    private Button btnEnderecosT12;
    private Button btnComprasT12;
    private Button btnListasComprasT12;
    private Button btnCartõesCreditoT12;
    private Toolbar toolbarT12;
    private TextView textCartoesCreditoT12;
    private ListView listCartoesCreditoT12;

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
    }

    @Override
    public void onClick(View v) {
        if (btnUsuariosT12.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
        }

        if (btnProdutosT12.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
        }

        if (btnEnderecosT12.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
        }

        if (btnComprasT12.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
        }

        if (btnListasComprasT12.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
        }

        if (btnCartõesCreditoT12.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
        }

    }
}
