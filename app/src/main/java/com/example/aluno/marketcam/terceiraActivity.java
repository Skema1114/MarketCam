package com.example.aluno.marketcam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class terceiraActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textEfetuarLoginT3;
    private EditText editEmailT3;
    private EditText editSenhaT3;
    private Button btnEntrarT3;
    private Button btnEsqueciSenhaT3;
    private CheckBox checkManterConectadoT3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        /*findViewById do TextView*/
        textEfetuarLoginT3 = (TextView) findViewById(R.id.textEfetuarLoginT3);

        /*findViewById dos EditText*/
        editEmailT3 = (EditText) findViewById(R.id.editEmailT3);
        editSenhaT3 = (EditText) findViewById(R.id.editSenhaT3);

        /*findViewById dos Button*/
        btnEntrarT3 = (Button) findViewById(R.id.btnEntrarT3);
        btnEsqueciSenhaT3 = (Button) findViewById(R.id.btnEsqueciSenhaT3);

        /*findViewById do CheckBox*/
        checkManterConectadoT3 = (CheckBox) findViewById(R.id.checkManterConectadoT3);

        /*setOnClickListener dos Button*/
        btnEntrarT3.setOnClickListener(this);
        btnEsqueciSenhaT3.setOnClickListener(this);

        /*setOnClickListener do CheckBox*/
        checkManterConectadoT3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
