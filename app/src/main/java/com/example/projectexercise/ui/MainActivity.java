package com.example.projectexercise.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectexercise.apo.pojo.login.LoginResponseModel;
import com.example.projectexercise.LoginContract;
import com.example.projectexercise.PresenterManager;
import com.example.projectexercise.R;

public class MainActivity extends AppCompatActivity implements LoginContract.LoginView {
    Button login_btn;
    EditText account_edt,password_edt;
    LoginContract.LoginView view = this;
    PresenterManager presenterManager = new PresenterManager();
    String token;
    SharedPreferences pref;
    @Override
    public void showToken(String token) {
        this.token = token;
        pref = getSharedPreferences("DATA",MODE_PRIVATE);
        pref.edit().putString("token",token).apply();
        Log.d("token_a", ""+pref.getString("token",""));
    }

    @Override
    public void showStatus(Integer status) {
        if(status == 0){
            Log.d("status_a", String.valueOf(status));
            Intent intent = new Intent(MainActivity.this, FunctionPage.class);
            startActivity(intent);
        }
        else if (status == 2){
            Log.d("status_b", String.valueOf(status));
            Toast.makeText(MainActivity.this, "無法取得連線", Toast.LENGTH_SHORT).show();
        }
        else{
            Log.d("status_c", String.valueOf(status));
            Toast.makeText(MainActivity.this, "帳號或密碼錯誤", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void showError(String e) {
        Toast.makeText(MainActivity.this,e,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = findViewById(R.id.login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account_edt = findViewById(R.id.account);
                password_edt = findViewById(R.id.password);
                String account = account_edt.getText().toString();
                String password = password_edt.getText().toString();
                LoginResponseModel.Account login = new LoginResponseModel.Account(account, password);
                presenterManager.onAttachLogin(view);
                presenterManager.getLogin(login);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        Log.d("MainActivity", "onDestroy");
    }
}

