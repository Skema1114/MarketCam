package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aluno.marketcam.R;

import java.util.List;

import interacao.Compra;
import interacao.Lista;

/**
 * Created by Rafael Martins on 08/12/2016.
 */

public class ListaAdapter extends BaseAdapter {
    private Context context;
    private List<Lista> lista;

    public ListaAdapter(Context ctx , List<Lista> listas){
        this.context = ctx;
        this.lista = listas;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Lista list = lista.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;
            convertView = inflater.inflate(R.layout.lista, null) ;
        }
        TextView textViewEsquerda = (TextView) convertView.findViewById(R.id.textListarListasEsquerda);
        textViewEsquerda.setText("\n"+
                "(ID):  "+
                "\nNOME:  "+
                "\nDATA E HORA:  "+
                "\nVALOR_TOTAL:  "+
                "\n");


        TextView textViewDireita = (TextView) convertView.findViewById(R.id.textListarListasDireita);
        textViewDireita.setText("\n"+
                ""+list.getId_lista()+
                "\n"+list.getNome()+
                "\n"+list.getData_hora()+
                "\n"+list.getValor_total()+
                "\n");

        return convertView;
    }
}
