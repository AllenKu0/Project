package com.example.projectexercise.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.projectexercise.R;
import com.example.projectexercise.adapter.SearchResultAdapter;
import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchResultPage extends AppCompatActivity{
    SearchResultAdapter searchAdapterResult;
    RecyclerView recyclerView ;
    Toolbar toolbar;
    TextView count_txt;
    int size;
    //-----------------------------------//
    ArrayList<String> So_id = new ArrayList<>();
    ArrayList<String> Online_Date = new ArrayList<>();
    ArrayList<String> Customer = new ArrayList<>();
    ArrayList<String> Mo_id = new ArrayList<>();
    ArrayList<String> Item_Name = new ArrayList<>();
    ArrayList<String> Qty = new ArrayList<>();
    ArrayList<String> Demand_Complete_Date = new ArrayList<>();
    ArrayList<String> Tech_Routing_Name = new ArrayList<>();
    ArrayList<String> Status = new ArrayList<>();
    //-----------------------------------//
    public List<ResultMoDataModel> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_search_result);
        recyclerView = findViewById(R.id.recyclerview);
        count_txt = findViewById(R.id.count);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("進度表查詢");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SearchResultPage.this, SearchPage.class);
                startActivity(intent);
            }
        });
        getBundle();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));    //分隔線
        searchAdapterResult = new SearchResultAdapter(this,dataList);
        recyclerView.setAdapter(searchAdapterResult);
        count_txt.setText("共"+size+"筆");
    }
    public void getBundle(){
        Bundle bundle = getIntent().getExtras();
        dataList = (List<ResultMoDataModel>) bundle.getSerializable("searchResult");
        size = bundle.getInt("Size");

    }

}