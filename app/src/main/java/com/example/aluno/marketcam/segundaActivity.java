package com.example.aluno.marketcam;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

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
        radioFemininoT2.setOnClickListener(this);
        radioMasculinoT2.setOnClickListener(this);
        radioMercadoT2.setOnClickListener(this);
        radioClienteT2.setOnClickListener(this);

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




    }

    @Override
    public void onClick(View v) {


    }
}
