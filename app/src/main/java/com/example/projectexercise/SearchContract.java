package com.example.projectexercise;

import java.util.List;

public interface SearchContract {

    interface SearchView{
        void showData(List<String> data,int isChange);
        void showDataError(String e);
    }
    interface Presenter<S extends SearchView>{
        void onAttachSearch(S searchView);
        void getSearch(String putIn,String token,int isChange);
    }
}
