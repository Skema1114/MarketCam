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

import interacao.Usuario;

/**
 * Created by Rafael Martins on 07/12/2016.
 */

public class UsuarioAdapter extends BaseAdapter{
    private Context context ;
    private List<Usuario> lista ;

    public UsuarioAdapter(Context ctx , List<Usuario> usuarios){
        this.context = ctx ;
        this.lista = usuarios ;
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
        Usuario usuario = lista.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;
            convertView = inflater.inflate(R.layout.usuario, null) ;
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textListarUsuarios);
        textView.setText(usuario.getNome());

        return convertView;
    }
}

