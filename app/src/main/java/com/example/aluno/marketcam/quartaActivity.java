package com.example.aluno.marketcam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class quartaActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textAdicionarProdutoT4;
    private TextView textProdutoT4;
    private TextView textQuantidadeT4;
    private AutoCompleteTextView textautocompleteProdutoT4;
    private EditText editQuantidadeT4;
    private Button btnAdicionarProdutoT4;
    private Button btnAdicionarCodigoBarrasT4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta);

        /*findViewById*/
        /*findViewById dos TextView*/
        textAdicionarProdutoT4 = (TextView) findViewById(R.id.textAdicionarProdutoT4);
        textProdutoT4 = (TextView) findViewById(R.id.textProdutoT4);
        textQuantidadeT4 = (TextView) findViewById(R.id.textQuantidadeT4);

        /*findViewById dos AutoCompleteTextView*/
        textautocompleteProdutoT4 = (AutoCompleteTextView) findViewById(R.id.textautocompleteProdutoT4);

        /*findViewById dos EditText*/
        editQuantidadeT4 = (EditText) findViewById(R.id.editQuantidadeT4);

        /*findViewById dos Button*/
        btnAdicionarProdutoT4 = (Button) findViewById(R.id.btnAdicionarProdutoT4);
        btnAdicionarCodigoBarrasT4 = (Button) findViewById(R.id.btnAdicionarCodigoBarrasT4);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnAdicionarProdutoT4.setOnClickListener(this);
        btnAdicionarCodigoBarrasT4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
