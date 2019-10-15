package com.example.aluno.marketcam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class primeiraActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnJCadastroT1;
    private Button btnNCadastroT1;
    private ImageView imageLogoT1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);

         /*findViewById*/
         /*findViewById dos Button*/
        btnJCadastroT1 = (Button) findViewById(R.id.btnJCadastroT1);
        btnNCadastroT1 = (Button) findViewById(R.id.btnNCadastroT1);

        /*findViewById dos ImageView*/
        imageLogoT1 = (ImageView) findViewById(R.id.imageLogoT1);


         /*setOnClickListener*/
         /*setOnClickListener dos Button*/
        btnJCadastroT1.setOnClickListener(this);
        btnNCadastroT1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (btnJCadastroT1.isPressed()) {
            Intent intent = new Intent(this, terceiraActivity.class);
            startActivity(intent);
        }
        if (btnNCadastroT1.isPressed()) {
            Intent intent = new Intent(this, segundaActivity.class);
            startActivity(intent);


        }
    }
}