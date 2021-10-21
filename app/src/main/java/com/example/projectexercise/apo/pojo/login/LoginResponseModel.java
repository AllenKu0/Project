package com.example.projectexercise.apo.pojo.login;

public class LoginResponseModel {
    public int status;
    public String token;

    public LoginResponseModel(String token, int status){
        this.status = status;
        this.token = token;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }

    public String getToken() {
        return token;
    }
    public void setToken(){
        this.token = token;
    }
    public static class Account{
        public String account;
        public String password;

        public Account(String account, String password){
            this.account = account;
            this.password = password;
        }
        public String getAccount() {
            return account;
        }
        public void setAccount(String account){
            this.account = account;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password){
            this.password = password;
        }
    }

}
