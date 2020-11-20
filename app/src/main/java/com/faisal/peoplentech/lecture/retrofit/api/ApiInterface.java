package com.faisal.peoplentech.lecture.retrofit.api;




import com.faisal.peoplentech.lecture.retrofit.model.Anim;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;


public interface ApiInterface {


    @GET("aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json?fbclid=IwAR3OCo6brixOSn80nXjD04UwKoR82wKxx3iZdceF5nv9XPt9gh3Q9kO13xo")
    Call<List<Anim>> getData();


}
