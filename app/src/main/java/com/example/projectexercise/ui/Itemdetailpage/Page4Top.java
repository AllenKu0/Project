package com.example.projectexercise.ui.Itemdetailpage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectexercise.R;
import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;
import com.example.projectexercise.ui.ItemDetailPage;

import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Page4Top#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page4Top extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //---------------------------------------//
    private TextView so_id;
    private TextView mo_id;
    private TextView item_id;
    private TextView item_name;
    private TextView online_date;
    private TextView qty;
    private TextView start_date;
    private TextView complete_date;
    private TextView tech_routing_name;
    private TextView status;

    public Page4Top() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Page4.
     */
    // TODO: Rename and change types and number of parameters
    public static Page4Top newInstance(String param1, String param2) {
        Page4Top fragment = new Page4Top();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_page3,container,false);
        ItemDetailPage itemDetail = (ItemDetailPage)getActivity();
        ResultMoDataModel top_data = itemDetail.getPage();
        so_id =(TextView) rootView.findViewById(R.id.so_id);
        mo_id = (TextView)rootView.findViewById(R.id.mo_id);
        item_id = (TextView)rootView.findViewById(R.id.item_id);
        item_name = (TextView)rootView.findViewById(R.id.item_name);
        online_date = (TextView)rootView.findViewById(R.id.online_date);
        qty = (TextView)rootView.findViewById(R.id.qty);
        start_date = (TextView)rootView.findViewById(R.id.start_date);
        complete_date = (TextView)rootView.findViewById(R.id.complete_date);
        tech_routing_name = (TextView)rootView.findViewById(R.id.tech_routing_name);
        status = (TextView)rootView.findViewById(R.id.status);

        so_id.setText(top_data.getSo_id());
        mo_id.setText(top_data.getMo_id());
        item_id.setText(top_data.getItem_id());
        item_name.setText(top_data.getItem_name());
        qty.setText("生產數量:"+top_data.getQty());
        online_date.setText("上線時間"+top_data.getOnline_date());
        start_date.setText("上線時間:"+top_data.getOnline_date());
        if(top_data.getComplete_date().equals("")){
            complete_date.setText("結關日:null");
        }
        else{
            complete_date.setText("結關日:"+top_data.getComplete_date());
        }
        tech_routing_name.setText("");

        return rootView;
    }
}
/*
top_data.getRelated_tech_route().getTech_routing_name()
if(String.valueOf(top_data.getRelated_tech_route().getStatus()).equals("2")){
            status.setText("生效");
        }
        else {
            status.setText("失效");
        }
 */