package com.example.projectexercise.apo;

import com.example.projectexercise.apo.pojo.customer.CustomerModel;
import com.example.projectexercise.apo.pojo.login.LoginResponseModel;
import com.example.projectexercise.apo.pojo.momanufacturemodel.MoManufactureModel;
import com.example.projectexercise.apo.pojo.order.SoIdModel;
import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyAPIService {
    @POST("auth/login")
    Observable<LoginResponseModel> postLogin(@Body LoginResponseModel.Account account);
    @GET("app-search-so")
    Observable<List<SoIdModel>> getSoId(
            @Query("so_id") String so_id,
            @Query("token") String token
    );
    @GET("app-search-customer")
    Observable<List<CustomerModel>> getCustomer(
            @Query("customer_name") String customer_name,
            @Query("token") String token
    );
    @GET("app-search-mo")
    Observable<List<MoManufactureModel>> getMoManufacture(
            @Query("mo_id") String mo_id,
            @Query("token") String token
    );
    @GET("get-now-manufacture")
    Observable<List<ResultMoDataModel>> getResultMo(
            @Query("token") String token,
            @Query("manufacture") String manufacture,
            @Query("customer") String customer,
            @Query("online_date") String online_date,
            @Query("sale_order") String sale_order,
            @Query("routing_level") String routing_level
    );
    /*
    @GET("get-prev-manufacture")
    Observable<List<>>

    @GET("get-manufacture")
    Observable<Response<List<ResultMoData>>> getPostManufacture(
            @Query("token") String token,
            @Query("manufacture") String manufacture,
            @Query("customer") String customer,
            @Query("online_date") String online_date,
            @Query("sale_order") String sale_order,
            @Query("routing_level") String routing_level
    );
    */
}
