package com.faisal.peoplentech.lecture.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://gist.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}