package com.example.aluno.marketcam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class sextaActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textCriarListaT6;
    private TextView textNomeListaT6;
    private EditText editNomeListaT6;
    private Switch switchFavoritoT6;
    private Button btnCriarT6;
    private ImageView imageLogoT6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexta);

        /*findViewById*/
        /*findViewById dos TextView*/
        textCriarListaT6 = (TextView) findViewById(R.id.textCriarListaT6);
        textNomeListaT6 = (TextView) findViewById(R.id.textNomeListaT6);

        /*findViewById dos EditText*/
        editNomeListaT6 = (EditText) findViewById(R.id.editNomeListaT6);

        /*findViewById do Switch*/
        switchFavoritoT6  = (Switch) findViewById(R.id.switchFavoritoT6);

        /*findViewById do Button*/
        btnCriarT6 = (Button) findViewById(R.id.btnCriarT6);

        /*findViewById dos ImageView*/
        imageLogoT6 = (ImageView) findViewById(R.id.imageLogoT6);



        /*setOnClickListener*/
        /*setOnClickListener do Switch*/
        switchFavoritoT6.setOnClickListener(this);

        /*setOnClickListener do Button*/
        btnCriarT6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
