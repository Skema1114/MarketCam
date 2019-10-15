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
import interacao.Endereco;

/**
 * Created by Rafael Martins on 08/12/2016.
 */

public class CompraAdapter extends BaseAdapter {
    private Context context;
    private List<Compra> lista;

    public CompraAdapter(Context ctx , List<Compra> compras){
        this.context = ctx;
        this.lista = compras;
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
        Compra compra = lista.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;
            convertView = inflater.inflate(R.layout.compra, null) ;
        }
        TextView textViewEsquerda = (TextView) convertView.findViewById(R.id.textListarComprasEsquerda);
        textViewEsquerda.setText("\n"+
                "(ID):  "+
                "\n(ID)CARRINHO:  "+
                "\nDATA:  "+
                "\nHORA:  "+
                "\nTAG:  "+
                "\nVALOR TOTAL:  "+
                "\n");


        TextView textViewDireita = (TextView) convertView.findViewById(R.id.textListarComprasDireita);
        textViewDireita.setText("\n"+
                ""+compra.getId_compra()+
                "\n"+compra.getCarrinho_id()+
                "\n"+compra.getData()+
                "\n"+compra.getHora()+
                "\n"+compra.getTag()+
                "\n"+compra.getValor_total()+
                "\n");

        return convertView;
    }
}
