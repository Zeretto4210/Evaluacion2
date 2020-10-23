package com.zeretto4210.ornithologistic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderAdaptador> {

    ArrayList<Bird> list;

    public Adapter(ArrayList<Bird> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderAdaptador onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bird_layout, null, false);
        return new ViewHolderAdaptador(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdaptador holder, int position) {
        holder.id.setText(list.get(position).getId());
        holder.name.setText(list.get(position).getName());
        holder.date.setText(list.get(position).getDate());
        holder.comment.setText(list.get(position).getComment());


    }

    @Override
    public int getItemCount() { //entregar la cantidad de contactos que tenemos
        return list.size();
    }

    public class ViewHolderAdaptador extends RecyclerView.ViewHolder {
        TextView id, name, date, comment;
        public ViewHolderAdaptador(@NonNull View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.cv_id);
            name = (TextView) itemView.findViewById(R.id.cv_name);
            date = (TextView)itemView.findViewById(R.id.cv_date);
            comment = (TextView) itemView.findViewById(R.id.cv_comment);
        }
    }
}
