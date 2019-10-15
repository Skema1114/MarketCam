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

import interacao.Endereco;
import interacao.Produto;

/**
 * Created by Rafael Martins on 08/12/2016.
 */

public class EnderecoAdapter extends BaseAdapter {
    private Context context;
    private List<Endereco> lista;

    public EnderecoAdapter(Context ctx , List<Endereco> enderecos){
        this.context = ctx;
        this.lista = enderecos;
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
        Endereco endereco = lista.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;
            convertView = inflater.inflate(R.layout.endereco, null) ;
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textListarEnderecos);
        textView.setText(endereco.getEstado());

        return convertView;
    }
}
