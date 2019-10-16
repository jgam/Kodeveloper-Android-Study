package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;


import com.example.recyclerviewexample.R;

import java.util.List;

public class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private List<String> items;
    private int itemLayout;

    public RecyclerViewAdapter(Context context, List<String> items, int itemLayout){
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(
                parent.getContext()
        ).inflate(itemLayout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void OnBindViewHolder(final ViewHolder holder, final int position){
        holder.text.setText(items.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public boolean onLongClick(View v){
                Toast.makeText(context, "item long clicked : " + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCout(){
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;

        ViewHolder(View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}