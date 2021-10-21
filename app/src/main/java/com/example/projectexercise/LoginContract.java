package com.example.projectexercise;

import android.view.View;

import com.example.projectexercise.apo.pojo.login.LoginResponseModel;

public interface LoginContract {

     interface LoginView{
          void showToken(String token);
          void showStatus (Integer status);
          void showError(String e);
     }
     interface Presenter<L extends LoginView>{
          void onAttachLogin(L loginView);
          void getLogin(LoginResponseModel.Account account) ;
     }
}
