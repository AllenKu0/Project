package com.example.projectexercise;

import com.example.projectexercise.apo.MyAPIService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager mInstance = new RetrofitManager();

    private MyAPIService myAPIService;
    private RetrofitManager(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("http://10.1.1.71:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        myAPIService = retrofit.create(MyAPIService.class);
    }
    public static RetrofitManager getInstance(){
        return mInstance;
    }
    public MyAPIService getAPI(){
        return myAPIService;
    }
}
