package br.unicamp.dynamicshape;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MeuAdaptador extends RecyclerView.Adapter<MeuAdaptador.MyHolder>{
    List<Exercicioo> listaExerc = new ArrayList<>();

    ItemClickListener itemClickListener;

    public MeuAdaptador(List<Exercicioo> list) { this.listaExerc = list; }

    @NonNull
    @Override
    public MeuAdaptador.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuAdaptador.MyHolder holder, @SuppressLint("RecyclerView") int position) {
        final Exercicioo exercData = listaExerc.get(position);

        holder.tvNomeItem.setText(exercData.getNome());
        holder.tvEmailItem.setText(exercData.getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(position, exercData);
            }
        });

        holder.tvDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaExerc.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaExerc.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView tvNomeItem, tvEmailItem, tvDeleteItem;

        public MyHolder (View itemView){
            super(itemView);

            tvNomeItem = itemView.findViewById(R.id.tvNomeItem);
            tvEmailItem = itemView.findViewById(R.id.tvEmailItem);
            tvDeleteItem = itemView.findViewById(R.id.tvDeleteItem);
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void UpdateData(int position, Exercicioo exercData) {
        listaExerc.remove(position);
        listaExerc.add(exercData);
        notifyItemChanged(position);
        notifyDataSetChanged();
    }
}
