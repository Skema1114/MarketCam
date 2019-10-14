package com.example.aluno.marketcam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class quintaActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView Espaço01T5, Espaço02T5, Espaço03T5, Espaço04T5, Espaço05T5, Espaço06T5, Espaço07T5, Espaço08T5, Espaço09T5, Espaço10T5;
    private TextView Espaço11T5, Espaço12T5, Espaço13T5, Espaço14T5, Espaço15T5, Espaço16T5, Espaço17T5, Espaço18T5, Espaço19T5, Espaço20T5;
    private TextView Espaço21T5, Espaço22T5, Espaço23T5, Espaço24T5, Espaço25T5, Espaço26T5, Espaço27T5, Espaço28T5, Espaço29T5, Espaço30T5;
    private TextView textEditarCadastroT5;
    private TextView textUsuarioT5;
    private TextView textNomeT5;
    private TextView textTelefoneT5;
    private TextView textSexoT5;
    private TextView textDataNascimentoT5;
    private TextView textEmailT5;
    private TextView textEnderecoT5;
    private TextView textCidadeT5;
    private TextView textEstadoT5;
    private TextView textCepT5;
    private TextView textRuaT5;
    private TextView textNumeroRuaT5;
    private TextView textBairroT5;
    private TextView textCartaoCreditoT5;
    private TextView textNumeroCartaoT5;
    private TextView textTitularT5;
    private TextView textValidadeT5;
    private TextView textCodigoT5;
    private TextView textSenhaT5;
    private TextView textSenhaAntigaT5;
    private TextView textNovaSenhaT5;
    private TextView textConfirmarNovaSenhaT5;
    private TextView textTipoUsuarioT5;
    private EditText editNomeT5;
    private EditText editTelefoneT5;
    private EditText editDataNascimentoT5;
    private EditText editEmailT5;
    private EditText editCepT5;
    private EditText editRuaT5;
    private EditText editNumeroRuaT5;
    private EditText editBairroT5;
    private EditText editNumeroCartaoT5;
    private EditText editTitularT5;
    private EditText editValidadetT5;
    private EditText editCodigoT5;
    private EditText editSenhaAntigaT5;
    private EditText editNovaSenhaT5;
    private EditText editConfirmarNovaSenhaT5;
    private RadioButton radioMasculinoT5;
    private RadioButton radioFemininoT5;
    private RadioButton radioClienteT5;
    private RadioButton radioMercadoT5;
    private CheckBox checkAtivaCartaoCreditoT5;
    private CheckBox checkCodigoCartaoT5;
    private CheckBox checkAtivaMudarSenhaT5;
    private RadioGroup radioSexoT5;
    private RadioGroup radioTipoUsuarioT5;
    private Spinner spinCidadeT5;
    private Spinner spinEstadoT5;
    private Button btnSalvarT5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta);

        /*findViewById*/
        /*findViewById dos TextView*/
        Espaço01T5 = (TextView) findViewById(R.id.Espaço01T5);
        Espaço02T5 = (TextView) findViewById(R.id.Espaço02T5);
        Espaço03T5 = (TextView) findViewById(R.id.Espaço03T5);
        Espaço04T5 = (TextView) findViewById(R.id.Espaço04T5);
        Espaço05T5 = (TextView) findViewById(R.id.Espaço05T5);
        Espaço06T5 = (TextView) findViewById(R.id.Espaço06T5);
        Espaço07T5 = (TextView) findViewById(R.id.Espaço07T5);
        Espaço08T5 = (TextView) findViewById(R.id.Espaço08T5);
        Espaço09T5 = (TextView) findViewById(R.id.Espaço09T5);
        Espaço10T5 = (TextView) findViewById(R.id.Espaço10T5);
        Espaço11T5 = (TextView) findViewById(R.id.Espaço11T5);
        Espaço12T5 = (TextView) findViewById(R.id.Espaço12T5);
        Espaço13T5 = (TextView) findViewById(R.id.Espaço13T5);
        Espaço14T5 = (TextView) findViewById(R.id.Espaço14T5);
        Espaço15T5 = (TextView) findViewById(R.id.Espaço15T5);
        Espaço16T5 = (TextView) findViewById(R.id.Espaço16T5);
        Espaço17T5 = (TextView) findViewById(R.id.Espaço17T5);
        Espaço18T5 = (TextView) findViewById(R.id.Espaço18T5);
        Espaço19T5 = (TextView) findViewById(R.id.Espaço19T5);
        Espaço20T5 = (TextView) findViewById(R.id.Espaço20T5);
        Espaço21T5 = (TextView) findViewById(R.id.Espaço21T5);
        Espaço22T5 = (TextView) findViewById(R.id.Espaço22T5);
        Espaço23T5 = (TextView) findViewById(R.id.Espaço23T5);
        Espaço24T5 = (TextView) findViewById(R.id.Espaço24T5);
        Espaço25T5 = (TextView) findViewById(R.id.Espaço25T5);
        Espaço26T5 = (TextView) findViewById(R.id.Espaço26T5);
        Espaço27T5 = (TextView) findViewById(R.id.Espaço27T5);
        Espaço28T5 = (TextView) findViewById(R.id.Espaço28T5);
        Espaço29T5 = (TextView) findViewById(R.id.Espaço29T5);
        Espaço30T5 = (TextView) findViewById(R.id.Espaço30T5);

        /*findViewById dos TextView*/
        textEditarCadastroT5 = (TextView) findViewById(R.id.textEditarCadastroT5);
        textUsuarioT5 = (TextView) findViewById(R.id.textUsuarioT5);
        textNomeT5 = (TextView) findViewById(R.id.textNomeT5);
        textTelefoneT5 = (TextView) findViewById(R.id.textTelefoneT5);
        textSexoT5 = (TextView) findViewById(R.id.textSexoT5);
        textDataNascimentoT5 = (TextView) findViewById(R.id.textDataNascimentoT5);
        textEmailT5 = (TextView) findViewById(R.id.textEmailT5);
        textEnderecoT5 = (TextView) findViewById(R.id.textEnderecoT5);
        textCidadeT5 = (TextView) findViewById(R.id.textCidadeT5);
        textEstadoT5 = (TextView) findViewById(R.id.textEstadoT5);
        textCepT5 = (TextView) findViewById(R.id.textCepT5);
        textRuaT5 = (TextView) findViewById(R.id.textRuaT5);
        textNumeroRuaT5 = (TextView) findViewById(R.id.textNumeroRuaT5);
        textBairroT5 = (TextView) findViewById(R.id.textBairroT5);
        textCartaoCreditoT5 = (TextView) findViewById(R.id.textCartaoCreditoT5);
        textNumeroCartaoT5 = (TextView) findViewById(R.id.textNumeroCartaoT5);
        textTitularT5 = (TextView) findViewById(R.id.textTitularT5);
        textValidadeT5 = (TextView) findViewById(R.id.textValidadeT5);
        textCodigoT5 = (TextView) findViewById(R.id.textCodigoT5);
        textSenhaT5 = (TextView) findViewById(R.id.textSenhaT5);
        textSenhaAntigaT5 = (TextView) findViewById(R.id.textSenhaAntigaT5);
        textNovaSenhaT5 = (TextView) findViewById(R.id.textNovaSenhaT5);
        textConfirmarNovaSenhaT5 = (TextView) findViewById(R.id.textConfirmarNovaSenhaT5);
        textTipoUsuarioT5 = (TextView) findViewById(R.id.textTipoUsuarioT5);

        /*findViewById dos EditText*/
        editNomeT5 = (EditText) findViewById(R.id.editNomeT5);
        editTelefoneT5 = (EditText) findViewById(R.id.editTelefoneT5);
        editDataNascimentoT5 = (EditText) findViewById(R.id.editDataNascimentoT5);
        editEmailT5 = (EditText) findViewById(R.id.editEmailT5);
        editCepT5 = (EditText) findViewById(R.id.editCepT5);
        editRuaT5 = (EditText) findViewById(R.id.editRuaT5);
        editNumeroRuaT5 = (EditText) findViewById(R.id.editNumeroRuaT5);
        editBairroT5 = (EditText) findViewById(R.id.editBairroT5);
        editNumeroCartaoT5 = (EditText) findViewById(R.id.editNumeroCartaoT5);
        editTitularT5 = (EditText) findViewById(R.id.editTitularT5);
        editValidadetT5 = (EditText) findViewById(R.id.editValidadetT5);
        editCodigoT5 = (EditText) findViewById(R.id.editCodigoT5);
        editSenhaAntigaT5 = (EditText) findViewById(R.id.editSenhaAntigaT5);
        editNovaSenhaT5 = (EditText) findViewById(R.id.editNovaSenhaT5);
        editConfirmarNovaSenhaT5 = (EditText) findViewById(R.id.editConfirmarNovaSenhaT5);

        /*findViewById dos RadioButton*/
        radioMasculinoT5 = (RadioButton) findViewById(R.id.radioMasculinoT5);
        radioFemininoT5 = (RadioButton) findViewById(R.id.radioFemininoT5);
        radioClienteT5 = (RadioButton) findViewById(R.id.radioClienteT5);
        radioMercadoT5 = (RadioButton) findViewById(R.id.radioMercadoT5);

        /*findViewById dos CheckBox*/
        checkAtivaCartaoCreditoT5 = (CheckBox) findViewById(R.id.checkAtivaCartaoCreditoT5);
        checkCodigoCartaoT5 = (CheckBox) findViewById(R.id.checkCodigoCartaoT5);
        checkAtivaMudarSenhaT5 = (CheckBox) findViewById(R.id.checkAtivaMudarSenhaT5);

        /*findViewById dos RadioGroup*/
        radioSexoT5 = (RadioGroup) findViewById(R.id.radioSexoT5);
        radioTipoUsuarioT5 = (RadioGroup) findViewById(R.id.radioTipoUsuarioT5);

        /*findViewById dos Spinner*/
        spinCidadeT5 = (Spinner) findViewById(R.id.spinCidadeT5);
        spinEstadoT5 = (Spinner) findViewById(R.id.spinEstadoT5);

        /*findViewById dos Button*/
        btnSalvarT5 = (Button) findViewById(R.id.btnSalvarT5);



        /*setOnClickListener*/
        /*setOnClickListener dos RadioButton*/
        radioMasculinoT5.setOnClickListener(this);
        radioFemininoT5.setOnClickListener(this);
        radioClienteT5.setOnClickListener(this);
        radioMercadoT5.setOnClickListener(this);

        /*setOnClickListener dos CheckBox*/
        checkAtivaCartaoCreditoT5.setOnClickListener(this);
        checkCodigoCartaoT5.setOnClickListener(this);
        checkAtivaMudarSenhaT5.setOnClickListener(this);

        /*setOnClickListener dos RadioGroup*/
        radioSexoT5.setOnClickListener(this);
        radioTipoUsuarioT5.setOnClickListener(this);

        /*setOnClickListener dos Button*/
        btnSalvarT5.setOnClickListener(this);



        /*SETANDO O CONTEUDO DO ESTADO QUE APARECERÁ DENTRO DO SPINNER*/
        ArrayAdapter<CharSequence> adapter_estado = ArrayAdapter.createFromResource(this, R.array.estadoSpinT2, android.R.layout.simple_spinner_item);
        adapter_estado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinEstadoT5.setAdapter(adapter_estado);

        /*SETANDO O CONTEUDO DA CIDADE QUE APARECERÁ DENTRO DO SPINNER*/
        ArrayAdapter<CharSequence> adapter_cidade = ArrayAdapter.createFromResource(this, R.array.cidadeSpinT2, android.R.layout.simple_spinner_item);
        adapter_cidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCidadeT5.setAdapter(adapter_cidade);
    }

    @Override
    public void onClick(View v) {

    }
}
