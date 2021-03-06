package com.example.aluno.marketcam;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import interacao.Usuario;

public class decimaTerceiraActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private TextView textEmailT13;
    private TextView textNomeT13;
    private Button btnCapturaCodigoT13;
    private ImageView imageLogoT13;
    private Button btnLimparT13;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decima_terceira);

        textEmailT13 = (TextView) findViewById(R.id.textEmailT13);
        textNomeT13 = (TextView) findViewById(R.id.textNomeT13);
        btnCapturaCodigoT13 = (Button) findViewById(R.id.btnCapturaCodigoT13);
        imageLogoT13 = (ImageView) findViewById(R.id.imageLogoT13);
        btnLimparT13 = (Button) findViewById(R.id.btnLimparT13);

        btnCapturaCodigoT13.setOnClickListener(this);
        btnLimparT13.setOnClickListener(this);

        btnLimparT13.setVisibility(View.INVISIBLE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    /* PARTE RETIRADA DO YOUTUBE */
    public void dispatchTakePictureIntent(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
       // btnVoltarT13.setVisibility(View.VISIBLE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageLogoT13.setImageBitmap(imageBitmap);
            btnLimparT13.setVisibility(View.VISIBLE);

        }

    }
    /* */


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.decima_terceira, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.CodigoBarrasMenu) {
            Intent intent = new Intent(this, decimaTerceiraActivity.class);
            startActivity(intent);

        } else if (id == R.id.MeuCarrinhoMenu) {
            Intent intent = new Intent(this, decimaQuartaActivity.class);
            startActivity(intent);

        } else if (id == R.id.AdministradorMenu) {
            Intent intent = new Intent(this, setimaActivity.class);
            startActivity(intent);

        } else if (id == R.id.CriarListasComprasMenu) {
            Intent intent = new Intent(this, sextaActivity.class);
            startActivity(intent);

        } else if (id == R.id.MinhasListasMenu) {


        } else if (id == R.id.HistoricoMenu) {


        } else if (id == R.id.EditarCadastroMenu) {
            Intent intent = new Intent(this, quintaActivity.class);
            startActivity(intent);

        } else if (id == R.id.SairMenu) {
            SharedPreferences preferences = getSharedPreferences("LoginActivityPreferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();

            Intent intent = new Intent(this, primeiraActivity.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.ReportarErroMenu) {
            Intent intent = new Intent(this, decimaQuintaActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnCapturaCodigoT13){
            //Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
            dispatchTakePictureIntent(v);
        }

        if(btnLimparT13.isPressed()){
            imageLogoT13.setImageResource(R.drawable.codigo_barras);
            btnLimparT13.setVisibility(View.INVISIBLE);
        }
    }
}
