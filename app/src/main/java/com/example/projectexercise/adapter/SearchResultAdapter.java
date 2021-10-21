package com.example.projectexercise.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexercise.R;
import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;
import com.example.projectexercise.ui.ItemDetailPage;

import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder> {
    //-----------------------------------//
    List<String> So_id = new ArrayList<>();
    List<String> Online_Date = new ArrayList<>();
    List<String> Customer = new ArrayList<>();
    List<String> Mo_id = new ArrayList<>();
    List<String> Item_Name = new ArrayList<>();
    List<String> Qty = new ArrayList<>();
    List<String> Demand_Complete_Date = new ArrayList<>();
    List<String> Tech_Routing_Name = new ArrayList<>();
    List<String> Status = new ArrayList<>();
    //-----------------------------------//
    List<ResultMoDataModel> recyclerview_data;
    ResultMoDataModel selected_data;
    //-----------------------------------//
    private Context mContext;
    public SearchResultAdapter(Context mContext, List<ResultMoDataModel> recyclerview_data){
        this.mContext = mContext;
        this.recyclerview_data = recyclerview_data;
        Log.d("Recyclerview","recyclerview_data construct");
    }
    /*public SearchAdapterResult(Context mContext,List<String> So_id, List<String> Online_Date, List<String> Customer, List<String> Mo_id , List<String> Item_Name ,
                               List<String> Qty, List<String> Demand_Complete_Date, List<String> Tech_Routing_Name,List<String> Status){
        this.mContext = mContext;
        this.So_id= So_id;
        this.Online_Date = Online_Date;
        this.Customer = Customer;
        this.Mo_id = Mo_id;
        this.Item_Name = Item_Name;
        this.Qty = Qty;
        this.Demand_Complete_Date = Demand_Complete_Date;
        this.Tech_Routing_Name = Tech_Routing_Name;
recyclerview_data.get(position).getRelated_tech_route().getTech_routing_name()""
        this.Status = Status;
    }*/
    private Context context;
    @NonNull
    @Override
    public SearchResultAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_result, parent ,false);
        context=parent.getContext();
        return new SearchResultAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding(position,context);
    }

    /*@Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.sequence.setText(String.valueOf(position+1));
        holder.mo_id.setText(Mo_id.get(position));
        holder.so_id.setText(So_id.get(position));
        holder.item_name.setText(Item_Name.get(position));
        holder.customer.setText(Customer.get(position));
        holder.qty.setText("數量:"+Qty.get(position));
        holder.demand_complete_date.setText("結關日:"+Demand_Complete_Date.get(position));
        holder.online_date.setText("上線日:"+Online_Date.get(position));
        holder.tech_routing_name.setText(Tech_Routing_Name.get(position));
        holder.status.setText("生效");
    }*/


    @Override
    public int getItemCount() {
        return recyclerview_data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView sequenceText;
        private final TextView mo_id;
        private final TextView so_id;
        private final TextView item_name;
        private final TextView customer;
        private final TextView qty;
        private final TextView complete_date;
        private final TextView online_date;
        private final TextView tech_routing_name;
        private final TextView status;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sequenceText = itemView.findViewById(R.id.sequence);
            mo_id = itemView.findViewById(R.id.mo_id);
            so_id = itemView.findViewById(R.id.so_id);
            item_name = itemView.findViewById(R.id.item_name);
            customer = itemView.findViewById(R.id.customer);
            qty = itemView.findViewById(R.id.qty);
            complete_date = itemView.findViewById(R.id.complete_date);
            online_date = itemView.findViewById(R.id.online_date);
            tech_routing_name = itemView.findViewById(R.id.tech_routing_name);
            status = itemView.findViewById(R.id.status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selected_data = recyclerview_data.get(getAdapterPosition());
                    Intent intent = new Intent(mContext, ItemDetailPage.class);
                    intent.putExtra("item_data",selected_data);
                    mContext.startActivity(intent);
                }
            });
        }
        void binding(int position, Context context){
            sequenceText.setText(String.valueOf(position+1));
            mo_id.setText(recyclerview_data.get(position).getMo_id());
            so_id.setText(recyclerview_data.get(position).getSo_id());
            item_name.setText(recyclerview_data.get(position).getItem_name());
            customer.setText(recyclerview_data.get(position).getCustomer());
            qty.setText("數量:"+recyclerview_data.get(position).getQty());
            context.getResources().getString(R.string.qwer);
            complete_date.setText("結關日:"+recyclerview_data.get(position).getComplete_date());
            online_date.setText("上線日:"+recyclerview_data.get(position).getOnline_date());
            //list包list好像不能這樣傳

            tech_routing_name.setText(recyclerview_data.get(position).getRelated_tech_route().getTech_routing_name());
             if(String.valueOf(recyclerview_data.get(position).getRelated_tech_route().getStatus()).equals("2")){
                status.setText("生效");
            }
            else {
                status.setText("失效");
            }

        }
    }
}
