package com.example.projectexercise;

import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ResultContract {
    interface ResultView{
        void showResultMoData(List<ResultMoDataModel> searchResults, int size);

    /*void showResultMoData(ArrayList<String> So_id, ArrayList<String> Online_Date, ArrayList<String> Customer, ArrayList<String> Mo_id , ArrayList<String> Item_Name ,
                          ArrayList<String> Qty, ArrayList<String> Demand_Complete_Date, ArrayList<String> Tech_Routing_Name, ArrayList<String> Status, int size);*/

        void showResultMoError(String e);
    }
    interface Presenter<R extends ResultView>{
        void onAttachResult(R resultView);
        void getResult(String key,String mo_id,String customer,String online_date,String so_id,String routing_level,int mode);
    }
}

