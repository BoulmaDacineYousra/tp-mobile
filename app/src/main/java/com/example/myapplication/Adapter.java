package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<viewH>{

    List<String> items;

    public Adapter(List<String> items){
        this.items=items;
    }


    @NonNull
    @Override
    public viewH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent ,false);
        return new viewH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull viewH holder, int position) {

            holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class viewH extends RecyclerView.ViewHolder{

    private Adapter adapter;
    TextView textView;
    public viewH(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.text);
        itemView.findViewById(R.id.item).setOnLongClickListener(view -> {
            adapter.items.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());

            return false;
        });

    }

    public viewH linkAdapter(Adapter adapter){
        this.adapter=adapter;
        return this;

    }
}
