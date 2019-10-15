package com.example.aluno.marketcam;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Adapter.UsuarioAdapter;
import BD.UsuarioBD;
import interacao.Usuario;
import util.Mensagem;

public class setimaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, DialogInterface.OnClickListener{
    private Button btnUsuariosT7;
    private Button btnProdutosT7;
    private Button btnEnderecosT7;
    private Button btnComprasT7;
    private Button btnListasComprasT7;
    private Button btnCartõesCreditoT7;
    private Toolbar toolbarT7;
    private TextView textUsuariosT7;
    private ListView listUsuariosT7;

    /*Adapter*/
    private ListView lista;
    private List<Usuario> usuarioList;
    private UsuarioAdapter usuarioAdapter;
    private UsuarioBD usuarioBD;

    /*REFERENTE AO "MENU", EDITAR, EXCLUIR*/
    private AlertDialog alertDialog;
    private AlertDialog  alertConfirmacao;
    private int idPosicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setima);

        /*findViewById*/
        /*findViewById dos Button*/
        btnUsuariosT7 = (Button) findViewById(R.id.btnUsuariosT7);
        btnProdutosT7 = (Button) findViewById(R.id.btnProdutosT7);
        btnEnderecosT7 = (Button) findViewById(R.id.btnEnderecosT7);
        btnComprasT7 = (Button) findViewById(R.id.btnComprasT7);
        btnListasComprasT7 = (Button) findViewById(R.id.btnListasComprasT7);
        btnCartõesCreditoT7 = (Button) findViewById(R.id.btnCartõesCreditoT7);

        /*findViewById do Toolbar*/
        toolbarT7 = (Toolbar) findViewById(R.id.toolbarT7);

        /*findViewById do TextView*/
        textUsuariosT7 = (TextView) findViewById(R.id.textUsuariosT7);

        /*findViewById do ListView*/
        listUsuariosT7 = (ListView) findViewById(R.id.listUsuariosT7);


        /*setOnClickListener*/
        /*setOnClickListener dos Button*/
        btnUsuariosT7.setOnClickListener(this);
        btnProdutosT7.setOnClickListener(this);
        btnEnderecosT7.setOnClickListener(this);
        btnComprasT7.setOnClickListener(this);
        btnListasComprasT7.setOnClickListener(this);
        btnCartõesCreditoT7.setOnClickListener(this);

        /*setOnClickListener do ListView*/
        //listUsuariosT7.setOnClickListener(this);


        /*Adapter*/
        usuarioBD =  new UsuarioBD(this);
        usuarioList = usuarioBD.ListaUsuario();
        usuarioAdapter = new UsuarioAdapter(this, usuarioList);

        lista = (ListView) findViewById(R.id.listUsuariosT7);
        lista.setAdapter(usuarioAdapter);
        //lista.setOnItemClickListener(this);


        /*REFERENTE AO "MENU", EDITAR, EXCLUIR*/
        alertDialog = Mensagem.criarAlertDialog(this);
        alertConfirmacao = Mensagem.CriarDialogConfirmacao(this, "Sair",
                "Deseja Realmente Sair?", R.drawable.sair,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        usuarioBD =  new UsuarioBD(this) ;
        usuarioList = usuarioBD.ListaUsuario() ;
        usuarioAdapter = new UsuarioAdapter(this , usuarioList) ;
        lista = (ListView) findViewById(R.id.listUsuariosT7);
        lista.setAdapter(usuarioAdapter);
        lista.setOnItemClickListener(this);

    }



    @Override
    public void onClick(View v) {
        if (btnUsuariosT7.isPressed()) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnProdutosT7.isPressed()) {
            Intent intent = new Intent(this, oitavaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnEnderecosT7.isPressed()) {
            Intent intent = new Intent(this, nonaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnComprasT7.isPressed()) {
            Intent intent = new Intent(this, decimaActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnListasComprasT7.isPressed()) {
            Intent intent = new Intent(this, decimaPrimeiraActivity.class);
            startActivity(intent);
            finish();
        }

        if (btnCartõesCreditoT7.isPressed()) {
            Intent intent = new Intent(this, decimaSegundaActivity.class);
            startActivity(intent);
            finish();
        }

    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = usuarioList.get(idPosicao).getId_usuario();

        switch(which){
            case 0:
                Intent intent = new Intent(this, quintaActivity.class);
                intent.putExtra("ID_USUARIO", id);
                startActivity(intent);
                finish();
                break;

            case 1:
                alertConfirmacao.show();
                break;

            case DialogInterface.BUTTON_POSITIVE:
                usuarioList.remove(idPosicao);
                usuarioBD.removerUsuario(id);
                lista.invalidateViews();
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                alertConfirmacao.dismiss();
                break;
        }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idPosicao = position;
        alertDialog.show();
    }
}
