package br.unicamp.dynamicshape;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MeuAdaptador extends RecyclerView.Adapter<MeuAdaptador.MyHolder>{
    List<Peso> listaExerc;

    ItemClickListener itemClickListener;

    public MeuAdaptador(List<Peso> list) { this.listaExerc = list; }

    @NonNull
    @Override
    public MeuAdaptador.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuAdaptador.MyHolder holder, @SuppressLint("RecyclerView") int position) {
        final Peso exercData = listaExerc.get(position);

        holder.btnNome.setText(exercData.getNome());

        holder.btnNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemClickListener.onItemClick(position, exercData);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listaExerc.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        Button btnNome;

        public MyHolder (View itemView){
            super(itemView);

            btnNome = itemView.findViewById(R.id.btnNome);

        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void UpdateData(int position, Peso exercData) {
        listaExerc.remove(position);
        listaExerc.add(exercData);
        notifyItemChanged(position);
        notifyDataSetChanged();
    }
}
