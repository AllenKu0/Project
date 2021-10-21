package com.example.projectexercise.ui.Itemdetailpage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectexercise.ResultContract;
import com.example.projectexercise.adapter.Page1BottomAdapter;
import com.example.projectexercise.PresenterManager;
import com.example.projectexercise.R;
import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;
import com.example.projectexercise.ui.ItemDetailPage;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Page1Bottom#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page1Bottom extends Fragment implements ResultContract.ResultView {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private String  online_date="";
    private String key;
    private ResultContract.ResultView resultView = this;
    //-----------------------------//
    PresenterManager presenterManager = new PresenterManager();
    Page1BottomAdapter page1Adapter;
    public Page1Bottom() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Page1Buttom.
     */
    // TODO: Rename and change types and number of parameters
    public static Page1Bottom newInstance(String param1, String param2) {
        Page1Bottom fragment = new Page1Bottom();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment","onCreate");
        SharedPreferences pref = ((AppCompatActivity)getActivity()).getSharedPreferences("DATA",Context.MODE_PRIVATE);
        key = pref.getString("token","");
        ItemDetailPage itemDetail =(ItemDetailPage) getActivity();
        ResultMoDataModel bottom_input_data = itemDetail.getPage();
        presenterManager.onAttachResult(resultView);
        presenterManager.getResult(key,bottom_input_data.getMo_id(),bottom_input_data.getCustomer(),online_date,bottom_input_data.getSo_id(),"",1);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Fragment","onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page1_buttom, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        return view;
    }

    @Override
    public void showResultMoData(List<ResultMoDataModel> searchResults, int size) {
        Log.d("pageAdapter","pageAdapter construct");
        page1Adapter = new Page1BottomAdapter(searchResults,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(page1Adapter);
        Log.d("Adapter","Adapter connected");
    }

    @Override
    public void showResultMoError(String e) {

    }
}