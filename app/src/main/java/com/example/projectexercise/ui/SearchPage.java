package com.example.projectexercise.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexercise.ResultContract;
import com.example.projectexercise.SearchContract;
import com.example.projectexercise.PresenterManager;
import com.example.projectexercise.R;
import com.example.projectexercise.adapter.SearchAdapter;
import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static com.example.projectexercise.adapter.SearchAdapter.so_item;

public class SearchPage extends AppCompatActivity implements SearchContract.SearchView, ResultContract.ResultView {
    Toolbar toolbar;
    EditText date_edt,so_id_edt,client_edt,mo_id_edt;
    //dateText
    //seleterNumberBtn
    Button date_select_btn,so_id_select_btn,client_select_btn,mo_id_select_btn,search_btn;
    SearchContract.SearchView searchView = this;
    ResultContract.ResultView resultView = this;
    PresenterManager presenterManager = new PresenterManager();
    private SearchAdapter mSearchAdapter;
    List<String> data= new ArrayList<>();
    String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_search);

        init();
        SharedPreferences pref = getSharedPreferences("DATA",MODE_PRIVATE);
        key = pref.getString("token","");
        toolbar.setTitle("進度表查詢");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d("token_plus",key);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SearchPage.this, FunctionPage.class); //context = getApplicationContext()
                startActivity(intent);
            }
        });

        date_select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String datetime = String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(dayOfMonth);
                        date_edt.setText(datetime);
                    }
                },year,month,day).show();
            }
        });
        so_id_select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String so_id = so_id_edt.getText().toString();
                presenterManager.onAttachSearch(searchView);
                presenterManager.getSearch(so_id,key,0);
            }
        });
        client_select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customer = client_edt.getText().toString();
                presenterManager.onAttachSearch(searchView);
                presenterManager.getSearch(customer,key,1);
            }
        });
        mo_id_select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mo_id = mo_id_edt.getText().toString();
                presenterManager.onAttachSearch(searchView);
                presenterManager.getSearch(Mo_id,key,2);

            }
        });
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String online_date = date_edt.getText().toString();
                String so_id = so_id_edt.getText().toString();
                String customer = client_edt.getText().toString();
                String mo_id = mo_id_edt.getText().toString();
                presenterManager.onAttachResult(resultView);
                presenterManager.getResult(key,mo_id,customer,online_date,so_id,"",0);
            }
        });
    }
    private void init(){
        toolbar=findViewById(R.id.toolbar);
        date_edt = findViewById(R.id.date);
        so_id_edt = findViewById(R.id.number);
        client_edt = findViewById(R.id.client);
        mo_id_edt = findViewById(R.id.mo_id);
        date_select_btn = findViewById(R.id.date_select);
        so_id_select_btn = findViewById(R.id.number_select);
        client_select_btn =findViewById(R.id.client_select);
        mo_id_select_btn = findViewById(R.id.mo_id_select);
        search_btn = findViewById(R.id.search);
    }
    @Override
    public void showData(List<String> data,int isChange) {
        this.data = data;
        final Dialog dialog = new Dialog(SearchPage.this,R.style.FullHeightDialog); //context = getApplicationContext() dialog是不行用的哦
        dialog.setContentView(R.layout.search_dialog);
        if(dialog.getWindow() != null){
            dialog.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        }
        RecyclerView mRecyclerView = dialog.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mSearchAdapter = new SearchAdapter(this,data,dialog);
        mRecyclerView.setAdapter(mSearchAdapter);
        dialog.setCanceledOnTouchOutside(true);
        if(isChange == 0){
            Log.d("isChange", String.valueOf(isChange));
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    so_id_edt.setText(so_item);
                    so_item = "";
                }
            });
            dialog.show();
        }
        else if (isChange == 1) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    client_edt.setText(so_item);
                    so_item="";
                }
            });
            dialog.show();
        }
        else {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    mo_id_edt.setText(so_item);
                    so_item = "";
                }
            });
            dialog.show();
        }
    }
    @Override
    public void showDataError(String e) {
        Toast.makeText(getApplicationContext(),e,Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public void showResultMoData(ArrayList<String> So_id, ArrayList<String> Online_Date, ArrayList<String> Customer, ArrayList<String> Mo_id, ArrayList<String> Item_Name, ArrayList<String> Qty, ArrayList<String> Demand_Complete_Date, ArrayList<String> Tech_Routing_Name, ArrayList<String> Status,int size) {
        if(So_id != null){
            //查客戶，Bundle會爆炸
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putStringArrayList("So_id",So_id);
            bundle.putStringArrayList("Online_Date",Online_Date);
            bundle.putStringArrayList("Customer",Customer);
            bundle.putStringArrayList("Mo_id",Mo_id);
            bundle.putStringArrayList("Item_Name",Item_Name);
            bundle.putStringArrayList("Qty",Qty);
            bundle.putStringArrayList("Demand_Complete_Date",Demand_Complete_Date);
            bundle.putStringArrayList("Tech_Routing_Name",Tech_Routing_Name);
            bundle.putStringArrayList("Status",Status);
            bundle.putInt("Size",So_id.size());
            intent.putExtras(bundle);
            intent.setClass(ProcessSearch.this,ProcessSearchResult.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(ProcessSearch.this,"查無資料",Toast.LENGTH_SHORT).show();
        }
    }*/

    @Override
    public void showResultMoData(List<ResultMoDataModel> searchResults, int size) {
        if(size == 0){
            Toast.makeText(this , "查無資料" , Toast.LENGTH_SHORT).show();
        }
        else{
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putInt("Size",size);
            bundle.putSerializable("searchResult",(Serializable) searchResults);
            intent.putExtras(bundle);
            intent.setClass(getApplicationContext(), SearchResultPage.class);
            startActivity(intent);
        }
    }

    @Override
    public void showResultMoError(String e) {
        Toast.makeText(getApplicationContext(),e,Toast.LENGTH_SHORT).show();
    }

}
