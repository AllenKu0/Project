package com.example.projectexercise.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexercise.R;
import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;

import java.util.List;

public class Page1BottomAdapter extends RecyclerView.Adapter<Page1BottomAdapter.MyViewHolder>{
    private List<ResultMoDataModel> bottom_get_data;
    private Context mContext;
    public Page1BottomAdapter(List<ResultMoDataModel> bottom_get_data, Context mContext){
        this.bottom_get_data = bottom_get_data;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.page1_recyclerview, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding(position);
    }


    @Override
    public int getItemCount() {
        Log.d("bottom_2" ,String.valueOf(bottom_get_data.get(0).getRelated_parent_part().getDownstream_child().size()));
        return bottom_get_data.get(0).getRelated_parent_part().getDownstream_child().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView number;
        private TextView material_id;
        private TextView bomkey_name;
        private TextView unit_qty;
        private TextView nuse_qty;
        private TextView unit_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            material_id = itemView.findViewById(R.id.material_id);
            bomkey_name = itemView.findViewById(R.id.bomkey_name);
            unit_qty = itemView.findViewById(R.id.unit_qty);
            nuse_qty = itemView.findViewById(R.id.nuse_qty);
            unit_id = itemView.findViewById(R.id.unit_id);
        }
        void binding(int position){
            number.setText(String.valueOf(position));
            bomkey_name.setText(bottom_get_data.get(0).getRelated_parent_part().getDownstream_child().get(position).getParent().getBomkey_name());
            material_id.setText(bottom_get_data.get(0).getRelated_parent_part().getDownstream_child().get(position).getParent().getMaterial_id());
            unit_qty.setText(bottom_get_data.get(0).getRelated_parent_part().getDownstream_child().get(position).getUnit_qty());
            nuse_qty.setText(bottom_get_data.get(0).getRelated_parent_part().getDownstream_child().get(position).getNuse_qty());
            unit_id.setText(bottom_get_data.get(0).getRelated_parent_part().getDownstream_child().get(position).getUnit_id ());
        }
    }
}
