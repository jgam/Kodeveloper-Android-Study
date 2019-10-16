package com.example.recyclerviewexamplee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
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
            public void onClick(View view){
                Toast.makeText(context, "item clicked : " + position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                Toast.makeText(context, "item long click : " + position, Toast.LENGTH_SHORT).show();
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
