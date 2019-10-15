package com.example.aluno.marketcam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.aluno.marketcam.R.id.btnAdicionarT14;

public class decimaQuintaActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textContatoT15;
    private TextView textDescricaoT15;
    private TextView textEscolhaAcaoT15;
    private EditText editMeuEmailT15;
    private EditText editMultiDescricaoT15;
    private RadioGroup radioAcaoT15;
    private RadioButton radioReclamacaoT15;
    private RadioButton radioReportarErroT15;
    private RadioButton radioDuvidaT15;
    private RadioButton radioMelhoriaT15;
    private Button btnEnviarT15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decima_quinta);

        /*findViewById*/
        /*findViewById do TextView*/
        textContatoT15 = (TextView) findViewById(R.id.textContatoT15);
        textDescricaoT15 = (TextView) findViewById(R.id.textDescricaoT15);
        textEscolhaAcaoT15 = (TextView) findViewById(R.id.textEscolhaAcaoT15);

        /*findViewById do EditText*/
        editMeuEmailT15 = (EditText) findViewById(R.id.editMeuEmailT15);
        editMultiDescricaoT15 = (EditText) findViewById(R.id.editMultiDescricaoT15);

        /*findViewById do RadioButton*/
        radioReclamacaoT15 = (RadioButton) findViewById(R.id.radioReclamacaoT15);
        radioReportarErroT15 = (RadioButton) findViewById(R.id.radioReportarErroT15);
        radioDuvidaT15 = (RadioButton) findViewById(R.id.radioDuvidaT15);
        radioMelhoriaT15 = (RadioButton) findViewById(R.id.radioMelhoriaT15);

        /*findViewById dos Button*/
        btnEnviarT15 = (Button) findViewById(R.id.btnEnviarT15);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnEnviarT15.setOnClickListener(this);

        /*setOnClickListener dos RadioButton*/
        radioReclamacaoT15.setOnClickListener(this);
        radioReportarErroT15.setOnClickListener(this);
        radioDuvidaT15.setOnClickListener(this);
        radioMelhoriaT15.setOnClickListener(this);

        /*Bloqueando o campo do Email*/
        editMeuEmailT15.setEnabled(false);

    }

    @Override
    public void onClick(View v) {

    }
}
