package br.unicamp.dynamicshape;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private List<Peso> listaPeso;
    Context context;


    public GridViewAdapter(Context context, List<Peso> parametroListaDog){
        this.context = context;
        this.listaPeso = parametroListaDog;
    }

    //Retorna o tamanho da lista
    @Override
    public int getCount() {
        return listaPeso.size();
    }

    @Override
    public Object getItem(int posicao) {
        return listaPeso.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_exercicio,viewGroup,false);
        }

        Button exercicioButton = view.findViewById(R.id.exercicioButton);

        final Peso peso = listaPeso.get(posicao);

        exercicioButton.setText(peso.getNome());

        exercicioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Exercicio.class);
                context.startActivity(intent);
            }
        });

        return view ;
    }
}