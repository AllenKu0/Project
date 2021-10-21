package com.example.projectexercise;

import android.util.Log;

import com.example.projectexercise.apo.MyAPIService;
import com.example.projectexercise.apo.pojo.customer.CustomerModel;
import com.example.projectexercise.apo.pojo.login.LoginResponseModel;
import com.example.projectexercise.apo.pojo.momanufacturemodel.MoManufactureModel;
import com.example.projectexercise.apo.pojo.order.SoIdModel;
import com.example.projectexercise.apo.pojo.resultmodata.ResultMoDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresenterManager <L extends LoginContract.LoginView,S extends SearchContract.SearchView,R extends ResultContract.ResultView>implements LoginContract.Presenter<L> , SearchContract.Presenter<S>, ResultContract.Presenter<R> {
    String  token;
    private L loginView;
    private S searchView;
    private R resultView;
    int status;
    private MyAPIService myAPIService = RetrofitManager.getInstance().getAPI();

    List<String> data = new ArrayList<>();

    @Override
    public void onAttachLogin(L loginView) {
        Log.d("View", "LoginView construct");
        this.loginView = loginView;
    }

    @Override
    public void getLogin(LoginResponseModel.Account account) {
        Log.d("sassas", account.getAccount());
        Observable<LoginResponseModel> call = myAPIService.postLogin(account);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponseModel>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LoginResponseModel loginResponseResponse) {
                        status = 1;
                        Log.d("onResponse", "onResponse: " + loginResponseResponse);
                        if (loginResponseResponse == null) {
                            loginView.showStatus(status);
                            Log.d("Status", "onResponse: " + loginResponseResponse);
                        } else {
                            status = loginResponseResponse.getStatus();
                            Log.d("status", "" + status);
                            if (status == 0) {
                                token = loginResponseResponse.getToken(); //回傳的資料已轉成LoginResponse物件，可直接用get方法取得特定欄位
                                Log.d("token", "" + token);
                                loginView.showStatus(status);
                                Log.d("status", "" + status);
                                loginView.showToken(String.valueOf(token));
                            } else {
                                loginView.showStatus(status);
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        status = 2;
                        loginView.showStatus(status);
                        Log.d("status", "" + status);
                        Log.d("ABC", "请求失敗");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("ABD", "请求成功");
                    }
                });
    }

    @Override
    public void onAttachSearch(S searchView) {
        Log.d("View", "SearchView construct");
        this.searchView = searchView;
    }

    @Override
    public void getSearch(String putIn, String token, int isChange) {
        Log.d("isChange", String.valueOf(isChange));
        if (isChange == 0) {
            Observable<List<SoIdModel>> call = myAPIService.getSoId(putIn, token);
            call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<SoIdModel>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull List<SoIdModel> orders) {
                            Log.d("response1", "" + orders.size());
                            data.clear();
                            if (orders != null) {
                                for (int i = 0; i < orders.size(); i++) {
                                    data.add(i, orders.get(i).getSo_id());
                                }
                                searchView.showData(data, isChange);
                            } else {
                                data.add(0, "查無資料");
                                searchView.showData(data, isChange);
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            searchView.showDataError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
        else if (isChange == 1) {
            Observable<List<CustomerModel>> call = myAPIService.getCustomer(putIn, token);
            call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<CustomerModel>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull List<CustomerModel> customers) {
                            if (customers != null) {
                                data.clear();
                                for (int i = 0; i < customers.size(); i++) {
                                    data.add(i, customers.get(i).getCustomer_name());
                                }
                                searchView.showData(data,isChange);
                                Log.d("Data", ""+data.get(0));
                            } else {
                                data.add(0, "查無資料");
                                searchView.showData(data,isChange);
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            searchView.showDataError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
        else {
            Log.d("isChange", String.valueOf(isChange));
            Observable<List<MoManufactureModel>> call = myAPIService.getMoManufacture(putIn, token);
            call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<MoManufactureModel>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull List<MoManufactureModel> moManufactures) {
                            data.clear();
                            if (moManufactures != null) {
                                for (int i = 0; i < moManufactures.size(); i++) {
                                    data.add(i, moManufactures.get(i).getMo_id());
                                }
                                searchView.showData(data, isChange);
                            } else {
                                data.add(0, "查無資料");
                                searchView.showData(data, isChange);
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            searchView.showDataError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    @Override
    public void onAttachResult(R resultView) {
        Log.d("View", "ResultView construct");
        this.resultView = resultView;
    }

    @Override
    public void getResult(String key, String mo_id, String customer, String online_date, String so_id, String routing_level, int mode) {
        if (mode == 0) {
            Log.d("getResultMo", "getResultMo running");
            Observable<List<ResultMoDataModel>> call = myAPIService.getResultMo(key, mo_id, customer, online_date, so_id, routing_level);
            call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<ResultMoDataModel>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull List<ResultMoDataModel> listResponse) {
                            if (listResponse.size() > 0) {
                                Log.d("SIZE(i)", String.valueOf(listResponse.size()));
                                Log.d("Result Status", String.valueOf(listResponse.get(0).getRelated_tech_route().getStatus()));
                                resultView.showResultMoData(listResponse, listResponse.size());
                                //mySearchCallback.sentResultMoData(So_id,Online_Date,Customer,Mo_id,Item_Name,Qty,Demand_Complete_Date,Tech_Routing_Name,Status,listResponse.body().size());
                                Log.d("SO_ID", "成功");
                            } else {
                                Log.d("EMPTY", "查無資料");
                                resultView.showResultMoData(listResponse, listResponse.size());
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            Log.d("getResultMo", "getResultMo running");
            Observable<List<ResultMoDataModel>> call = myAPIService.getResultMo(key, mo_id, customer, online_date, so_id, routing_level);
            call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<ResultMoDataModel>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull List<ResultMoDataModel> listResponse) {
                            if (listResponse != null) {
                                Log.d("SIZE(i) bottom_data", String.valueOf(listResponse.size()));
                                resultView.showResultMoData(listResponse, listResponse.size());
                                //mySearchCallback.sentResultMoData(So_id,Online_Date,Customer,Mo_id,Item_Name,Qty,Demand_Complete_Date,Tech_Routing_Name,Status,listResponse.body().size());
                                Log.d("SO_ID", "成功");

                            } else {
                                Log.d("EMPTY", "查無資料");
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

    }
}