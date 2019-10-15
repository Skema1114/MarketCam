package com.example.aluno.marketcam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import BD.UsuarioBD;
import interacao.Usuario;
import util.Mensagem;

public class segundaActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textTipoContaT2;
    private TextView textSexoT2;
    private TextView textInformeDadosT2;
    private TextView textDataNascimentoT2;
    private TextView textCidadeT2;
    private TextView textEstadoT2;
    private EditText editConfirmarSenhaT2;
    private EditText editEmailT2;
    private EditText editSenhaT2;
    private EditText editNomeT2;
    private RadioGroup radioTipoContaT2;
    private RadioButton radioClienteT2;
    private RadioButton radioMercadoT2;
    private RadioGroup radioSexoT2;
    private RadioButton radioMasculinoT2;
    private RadioButton radioFemininoT2;
    private Spinner spinCidadeT2;
    private Spinner spinEstadoT2;
    private DatePicker dateDataT2;
    private Button btnCadastrarseT2;

    private Usuario usuario ;
    private UsuarioBD usuarioBD ;
    private int idUsuario ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        /*Cadastro Usuario*/
        usuarioBD = new UsuarioBD(this);

        /*findViewById*/
        /*findViewById dos TextView*/
        textTipoContaT2 = (TextView) findViewById(R.id.textTipoContaT2);
        textSexoT2 = (TextView) findViewById(R.id.textSexoT2);
        textInformeDadosT2 = (TextView) findViewById(R.id.textInformeDadosT2);
        textDataNascimentoT2 = (TextView) findViewById(R.id.textDataNascimentoT2);
        textCidadeT2 = (TextView) findViewById(R.id.textCidadeT2);
        textEstadoT2 = (TextView) findViewById(R.id.textEstadoT2);

        /*findViewById dos EditText*/
        editConfirmarSenhaT2 = (EditText) findViewById(R.id.editConfirmarSenhaT2);
        editEmailT2 = (EditText) findViewById(R.id.editEmailT2);
        editSenhaT2 = (EditText) findViewById(R.id.editSenhaT2);
        editNomeT2 = (EditText) findViewById(R.id.editNomeT2);

        /*findViewById dos RadioButton\RadioGroup*/
        radioTipoContaT2 = (RadioGroup) findViewById(R.id.radioTipoContaT2);
        radioClienteT2 = (RadioButton) findViewById(R.id.radioClienteT2);
        radioMercadoT2 = (RadioButton) findViewById(R.id.radioMercadoT2);
        radioSexoT2 = (RadioGroup) findViewById(R.id.radioSexoT2);
        radioMasculinoT2 = (RadioButton) findViewById(R.id.radioMasculinoT2);
        radioFemininoT2 = (RadioButton) findViewById(R.id.radioFemininoT2);

        /*findViewById dos Spinner*/
        spinCidadeT2 = (Spinner) findViewById(R.id.spinCidadeT2);
        spinEstadoT2 = (Spinner) findViewById(R.id.spinEstadoT2);

        /*findViewById do Button*/
        btnCadastrarseT2 = (Button) findViewById(R.id.btnCadastrarseT2);

        /*findViewById do DatePicker*/
        dateDataT2  = (DatePicker) findViewById(R.id.dateDataT2);


        /*setOnClickListener*/
        /*setOnClickListener dos RadioButton*/
        //radioFemininoT2.setOnClickListener(this);
        //radioMasculinoT2.setOnClickListener(this);
        //radioMercadoT2.setOnClickListener(this);
        //radioClienteT2.setOnClickListener(this);

        /*setOnClickListener do Button*/
        btnCadastrarseT2.setOnClickListener(this);

        /*setOnClickListener do DatePicker*/
        dateDataT2.setOnClickListener(this);


         /*SETANDO O CONTEUDO DO ESTADO QUE APARECERÁ DENTRO DO SPINNER*/
        ArrayAdapter<CharSequence> adapter_estado = ArrayAdapter.createFromResource(this, R.array.estadoSpinT2, android.R.layout.simple_spinner_item);
        adapter_estado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinEstadoT2.setAdapter(adapter_estado);

        /*SETANDO O CONTEUDO DA CIDADE QUE APARECERÁ DENTRO DO SPINNER*/
        ArrayAdapter<CharSequence> adapter_cidade = ArrayAdapter.createFromResource(this, R.array.cidadeSpinT2, android.R.layout.simple_spinner_item);
        adapter_cidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCidadeT2.setAdapter(adapter_cidade);


        /*Cadastro Usuario*/
        idUsuario = getIntent().getIntExtra("ID_USUARIO", 0);

        if(idUsuario > 0){
            Usuario model = usuarioBD.buscarUsuario(idUsuario);

            editNomeT2.setText(model.getNome());
            if(radioClienteT2.isChecked()){
                radioClienteT2.setText("Cliente");
                radioClienteT2.setText(model.getPerfil_usuario());
            }else if(radioMercadoT2.isChecked()){
                radioMercadoT2.setText("Mercado");
                radioMercadoT2.setText(model.getPerfil_usuario());
            }
            if(radioMasculinoT2.isChecked()){
                radioMasculinoT2.setText("M");
                radioMasculinoT2.setText(model.getSexo());
            }else if(radioFemininoT2.isChecked()){
                radioFemininoT2.setText("F");
                radioFemininoT2.setText(model.getSexo());
            }
            /*dateDataT2.setText(model.getData_nascimento());*/
            spinCidadeT2.getSelectedItem().toString();
            spinEstadoT2.getSelectedItem().toString();
            editEmailT2.setText(model.getEmail());
            if((editSenhaT2==editConfirmarSenhaT2)&&(editConfirmarSenhaT2==editSenhaT2)){
                editSenhaT2.setText(model.getSenha());
            }else{
                //editSenhaT2.setError("Não deu");
            }
            setTitle(R.string.atualizar_usuario);
        }
    }



    protected void onDestoy(){
        usuarioBD.fechar();
        super.onDestroy();
    }

    public void cadastrarUsuario(){

        boolean validacao = true ;

        String nome = editNomeT2.getText().toString();
        if(radioClienteT2.isChecked()){
            radioClienteT2.setText("Cliente");
            String tipo_usuario = radioClienteT2.getText().toString();
        }else if (radioMercadoT2.isChecked()){
            radioMercadoT2.setText("Mercado");
            String tipo_usuario = radioMercadoT2.getText().toString();
        }
        if(radioMasculinoT2.isChecked()){
            radioMasculinoT2.setText("M");
            String tipo_usuario = radioMasculinoT2.getText().toString();
        }else if (radioFemininoT2.isChecked()){
            radioFemininoT2.setText("F");
            String tipo_usuario = radioFemininoT2.getText().toString();
        }
        spinCidadeT2.getSelectedItem().toString();
        spinEstadoT2.getSelectedItem().toString();
        String email = editEmailT2.getText().toString();
        String senha = editSenhaT2.getText().toString();


        if((nome == null) || (nome.equals(""))){
            validacao = false ;
            editNomeT2.setError(getString(R.string.obrigatorio));
        }

        if((email == null) || (email.equals(""))){
            validacao = false ;
            editEmailT2.setError(getString(R.string.obrigatorio));
        }

        if((senha == null) || (senha.equals(""))){
            validacao = false ;
            editSenhaT2.setError(getString(R.string.obrigatorio));

        }

        if(validacao){
            usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);


            if(idUsuario >0){
                usuario.setId_usuario(idUsuario);
            }

            long resultado = usuarioBD.salvarUsuario(usuario) ;

            if(resultado != -1){
                if(idUsuario >0){
                    Mensagem.Msg(this ,getString(R.string.mensagem_atualizar));
                }else{
                    Mensagem.Msg(this , getString(R.string.mensagem_cadastrar));
                }
                finish();
                startActivity(new Intent(this , quintaActivity.class));
            }else{
                Mensagem.Msg(this , getString(R.string.mensagem_erro));
            }
        }
    }

    @Override
    public void onClick(View v) {
        cadastrarUsuario();

    }
}
