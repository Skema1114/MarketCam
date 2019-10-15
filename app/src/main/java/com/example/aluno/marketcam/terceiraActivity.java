package com.example.aluno.marketcam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import BD.UsuarioBD;
import util.Mensagem;

public class terceiraActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textEfetuarLoginT3;
    private EditText editEmailT3;
    private EditText editSenhaT3;
    private Button btnEntrarT3;
    private Button btnEsqueciSenhaT3;
    private CheckBox checkManterConectadoT3;


    private static final String MANTER_CONECTADO = "manter conectado";
    private static final String PREFERENCE_NAME = "LoginActivityPreferences";
    private UsuarioBD helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        /*findViewById*/
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

        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnEntrarT3.setOnClickListener(this);
        btnEsqueciSenhaT3.setOnClickListener(this);

        /*setOnClickListener do CheckBox*/
        checkManterConectadoT3.setOnClickListener(this);


        helper = new UsuarioBD(this);
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        boolean conectado = sharedPreferences.getBoolean(MANTER_CONECTADO, false);
        if (conectado){
            chamardecimaTerceiraActivity();
        }
    }


    public void chamardecimaTerceiraActivity() {
        startActivity(new Intent(this, decimaTerceiraActivity.class));
        finish();

    }

    @Override
    public void onClick(View v) {
        if(btnEntrarT3.isPressed()){
            this.logar();
        }

    }



    public void logar() {

        String usuario = editEmailT3.getText().toString();
        String senha = editSenhaT3.getText().toString();

        boolean validacao = true;


        if ((usuario == null) || (usuario.equals(""))) {
            validacao = false;
            editEmailT3.setError(getString(R.string.emailObrigatorioT3));
        }
        if ((senha == null) || (senha.equals(""))) {
            validacao = false;
            editSenhaT3.setError(getString(R.string.senhaObrigatoriaT3));
        }

        if (validacao) {

            if (helper.logar(usuario, senha)) {
                chamardecimaTerceiraActivity();

                if (checkManterConectadoT3.isChecked()) {

                    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putBoolean(MANTER_CONECTADO, true);
                    editor.commit();
                }
            } else {
                Mensagem.Msg(this, getString(R.string.loginincorretoT3));
            }
        } else {
            Mensagem.Msg(this, getString(R.string.loginincorretoT3));
        }

    }

}

