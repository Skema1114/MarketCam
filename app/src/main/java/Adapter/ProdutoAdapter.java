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

import interacao.Produto;
import interacao.Usuario;

/**
 * Created by Rafael Martins on 08/12/2016.
 */

public class ProdutoAdapter extends BaseAdapter {
    private Context context;
    private List<Produto> lista;

    public ProdutoAdapter(Context ctx , List<Produto> produtos){
        this.context = ctx;
        this.lista = produtos;
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
        Produto produto = lista.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) ;
            convertView = inflater.inflate(R.layout.produto, null) ;
        }
        TextView textViewEsquerda = (TextView) convertView.findViewById(R.id.textListarProdutosEsquerda);
        textViewEsquerda.setText("\n"+
                "(ID):  "+
                "\n(ID)FOTO:  "+
                "\nCODIGO DE BARRAS:  "+
                "\nNOME:  "+
                "\nVALOR:  "+
                "\nLOTE:  "+
                "\nDESCRICAO:  "+
                "\n");


        TextView textViewDireita = (TextView) convertView.findViewById(R.id.textListarProdutosDireita);
        textViewDireita.setText("\n"+
                ""+produto.getId_produto()+
                "\n"+produto.getFoto_produto_id()+
                "\n"+produto.getCodigo_barras()+
                "\n"+produto.getNome()+
                "\n"+produto.getValor()+
                "\n"+produto.getLote()+
                "\n"+produto.getDescricao()+
                "\n");

        return convertView;
    }
}
