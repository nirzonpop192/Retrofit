package com.faisal.peoplentech.lecture.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.faisal.peoplentech.lecture.retrofit.adopter.AnimeViewAdopter;
import com.faisal.peoplentech.lecture.retrofit.adopter.IDetailsClickListener;
import com.faisal.peoplentech.lecture.retrofit.api.ApiClient;
import com.faisal.peoplentech.lecture.retrofit.api.ApiInterface;
import com.faisal.peoplentech.lecture.retrofit.model.Anim;
import com.faisal.peoplentech.lecture.retrofit.receiver.WifiReceiver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Anim> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AnimeViewAdopter mAdapter;
    BroadcastReceiver mNetworkReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        mAdapter = new AnimeViewAdopter(mList, new IDetailsClickListener() {
            @Override
            public void onClick(int position) {
                Anim anim=mList.get(position);
                Intent intent= new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("detailsKey", (Serializable) anim);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        call();

        mNetworkReceiver = new WifiReceiver();
        registerNetworkBroadcastForNougat();
    }

    private void call() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Anim>> call = apiService.getData();
        call.enqueue(new Callback<List<Anim>>() {
            @Override
            public void onResponse(@NonNull Call<List<Anim>> call, @NonNull Response<List<Anim>> response) {
                //   Log.e("Result", response.body().toString());
                if (response.body() != null) {
                    Log.e("Main", response.body().toString());
                    for (int i = 0; i < response.body().size(); i++) {
                        Anim anim = response.body().get(i);
                        mList.add(anim);
                    }
                    mAdapter.notifyDataSetChanged();

                } else {

                    Log.e("Main", "body is null");
                }

            }

            @Override
            public void onFailure(Call<List<Anim>> call, Throwable t) {
                Log.e("Error", "error");
            }
        });
    }

    private void registerNetworkBroadcastForNougat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregisterNetworkChanges() {
        try {
            unregisterReceiver(mNetworkReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterNetworkChanges();
    }
}
