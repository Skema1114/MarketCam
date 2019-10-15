package com.example.aluno.marketcam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import BD.EnderecoBD;
import BD.UsuarioBD;
import interacao.Endereco;
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

    private Usuario usuario;
    private UsuarioBD usuarioBD;
    private int idUsuario;

    private Endereco endereco;
    EnderecoBD enderecoBD;
    private int idEndereco;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        /*Cadastro Usuario*/
        usuarioBD = new UsuarioBD(this);
        enderecoBD = new EnderecoBD(this);

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
        dateDataT2 = (DatePicker) findViewById(R.id.dateDataT2);


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



        idUsuario = getIntent().getIntExtra("ID_USUARIO", 0);

        if(idUsuario > 0){
            Usuario model = usuarioBD.buscarUsuario(idUsuario);
            //Endereco model2 = enderecoBD.buscarEndereco(idEndereco);

            editNomeT2.setText(model.getNome());
            /*if((radioTipo = model.getNome()) == "cliente"){
                radioClienteT5.setChecked(true);
                nivelAcesso = 3;
            }else if ((radioTipo = model.getNome()) == "mercado"){
                radioMercadoT2.setChecked(true);
                nivelAcesso = 2;
            }
            if ((radioSexo = model.getNome()) == "M"){
                radioMasculinoT5.setChecked(true);
            }else if ((radioSexo = model.getNome()) == "F"){
                radioFemininoT5.setChecked(true);
            }*/
            //aqui vai a data do date piker
            editEmailT2.setText(model.getEmail());


            //setTitle(R.string.atualizar_usuario);
        }

        idEndereco = getIntent().getIntExtra("ID_ENDERECO", 0);

        if(idEndereco > 0){
            Endereco model2 = enderecoBD.buscarEndereco(idEndereco);


           // editNomeT2.setText(model.getNome());
            /*if((radioTipo = model.getNome()) == "cliente"){
                radioClienteT5.setChecked(true);
                nivelAcesso = 3;
            }else if ((radioTipo = model.getNome()) == "mercado"){
                radioMercadoT2.setChecked(true);
                nivelAcesso = 2;
            }
            if ((radioSexo = model.getNome()) == "M"){
                radioMasculinoT5.setChecked(true);
            }else if ((radioSexo = model.getNome()) == "F"){
                radioFemininoT5.setChecked(true);
            }*/
            //aqui vai a data do date piker
            //editEmailT2.setText(model2.getBairro());


            //setTitle(R.string.atualizar_usuario);
        }

    }


        public void cadastrarUsuario() {
            boolean validacao = true;
            String radioSexo = null;
            String radioTipo = null;
            int nivelAcesso = 0;


            String nome = editNomeT2.getText().toString();
            if (radioClienteT2.isChecked()) {
                radioTipo = "cliente";
                nivelAcesso = 3;
            } else if (radioMercadoT2.isChecked()) {
                radioTipo = "mercado";
                nivelAcesso = 2;
            }
            if (radioMasculinoT2.isChecked()) {
                radioSexo = "M";
            } else if (radioFemininoT2.isChecked()) {
                radioSexo = "F";
            }
            //String data = textDataNascimentoT2.;
            String email = editEmailT2.getText().toString();
            String senha = editSenhaT2.getText().toString();
            //String conf_senha = editConfirmarSenhaT2.getText().toString();


            if (validacao) {
                usuario = new Usuario();

                usuario.setNome(nome);
                usuario.setPerfil_usuario(radioTipo);
                usuario.setNivel_acesso_id(nivelAcesso);
                usuario.setSexo(radioSexo);
                //usuario.setData_nascimento();
                usuario.setEmail(email);
                usuario.setSenha(senha);


                if (idUsuario > 0) {
                    usuario.setId_usuario(idUsuario);
                }

                // long resultado = usuarioBD.salvarUsuario(usuario) ;
                long resultado = usuarioBD.salvarUsuario(usuario);

                if (resultado != -1) {
                    if (idUsuario > 0) {
                        Mensagem.Msg(this, getString(R.string.mensagem_atualizar));
                    } else {
                        Mensagem.Msg(this, getString(R.string.mensagem_cadastrar));
                    }
                    finish();
                    startActivity(new Intent(this, terceiraActivity.class));
                } else {
                    Mensagem.Msg(this, getString(R.string.mensagem_erro));
                }
            }
        }


        /* -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- -/- */
        /*Cadastro Endereço*/

        public void cadastrarEndereco() {

            boolean validacao = true;

            String cidade = spinCidadeT2.getSelectedItem().toString();
            String estado = spinEstadoT2.getSelectedItem().toString();

            String val_nome = editNomeT2.getText().toString();
            String val_email = editEmailT2.getText().toString();
            String val_senha = editSenhaT2.getText().toString();
            String val_conf_senha = editConfirmarSenhaT2.getText().toString();
            if ((val_nome == null) || (val_nome.equals(""))) {
                validacao = false;
                editNomeT2.setError(getString(R.string.nomeObrigatorioT2));
            }
            if ((val_email == null) || (val_email.equals(""))) {
                validacao = false;
                editEmailT2.setError(getString(R.string.emailObrigatorioT3));
            }
            if ((val_senha == null) || (val_senha.equals(""))) {
                validacao = false;
                editSenhaT2.setError(getString(R.string.senhaObrigatoriaT3));
            }
            if ((val_conf_senha == null) || (val_conf_senha.equals(""))) {
                validacao = false;
                editConfirmarSenhaT2.setError(getString(R.string.confirmar_senhaObrigatoriaT3));
            }



            if (validacao) {
                endereco = new Endereco();

                endereco.setCidade(cidade);
                endereco.setEstado(estado);


                if (idEndereco > 0) {
                    endereco.setId_endereco(idEndereco);
                }

                long resultado = enderecoBD.salvarEndereco(endereco);

                if (resultado != -1) {
                    if (idEndereco > 0) {
                        Mensagem.Msg(this, getString(R.string.mensagem_atualizar));
                    } else {
                        this.cadastrarUsuario();
                    }
                    finish();
                    //startActivity(new Intent(this, quintaActivity.class));
                } else {
                    Mensagem.Msg(this, getString(R.string.mensagem_erro));
                }
            }

        }

    @Override
    public void onClick(View v) {
        this.cadastrarEndereco();

    }
}
