package com.example.aluno.marketcam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class decimaQuartaActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textMeuCarrinhoT14;
    private TextView textValorTotalT14;
    private TextView textRecebeValorTotalT14;
    private Button btnAdicionarT14;
    private Button btnRemoverT14;
    private Button btnFinalizarPedidoT14;
    private ListView listCarrinhoT14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decima_quarta);

        /*findViewById*/
        /*findViewById do TextView*/
        textMeuCarrinhoT14 = (TextView) findViewById(R.id.textMeuCarrinhoT14);
        textValorTotalT14 = (TextView) findViewById(R.id.textValorTotalT14);
        textRecebeValorTotalT14 = (TextView) findViewById(R.id.textRecebeValorTotalT14);

        /*findViewById dos Button*/
        btnAdicionarT14 = (Button) findViewById(R.id.btnAdicionarT14);
        btnRemoverT14 = (Button) findViewById(R.id.btnRemoverT14);
        btnFinalizarPedidoT14 = (Button) findViewById(R.id.btnFinalizarPedidoT14);

        /*findViewById do ListView*/
        listCarrinhoT14 = (ListView) findViewById(R.id.listCarrinhoT14);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnAdicionarT14.setOnClickListener(this);
        btnRemoverT14.setOnClickListener(this);
        btnFinalizarPedidoT14.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
