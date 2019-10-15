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

import interacao.Cartao_Credito;
import interacao.Lista;

/**
 * Created by Rafael Martins on 08/12/2016.
 */

public class Cartao_CreditoAdapter extends BaseAdapter {
    private Context context;
    private List<Cartao_Credito> lista;

    public Cartao_CreditoAdapter(Context ctx , List<Cartao_Credito> cartao_creditos){
        this.context = ctx;
        this.lista = cartao_creditos;
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
        Cartao_Credito cartao_credito = lista.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;
            convertView = inflater.inflate(R.layout.cartao_credito, null) ;
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textListarCartao_Creditos);
        textView.setText(cartao_credito.getTitular_cartao());

        return convertView;
    }
}

