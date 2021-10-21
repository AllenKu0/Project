package com.example.projectexercise.adapter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexercise.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private List<String> data;
    private Context mContext;
    private Dialog dialog;
    public static String so_item;
    public SearchAdapter(Context mContext,List<String> data,Dialog dialog){
        this.data = data;
        this.mContext = mContext;
        this.dialog = dialog;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_item, parent ,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView item;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    so_item = item.getText().toString();
                    Toast.makeText(v.getContext(),"你選擇了"+item.getText().toString(),Toast.LENGTH_SHORT).show();
                    Log.d("selected", ""+so_item);
                    dialog.dismiss();
                }
            });
        }
        void binding(int position){
            item.setText(data.get(position));
        }
    }
}
