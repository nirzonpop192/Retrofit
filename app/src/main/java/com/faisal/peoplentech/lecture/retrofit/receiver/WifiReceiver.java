package com.faisal.peoplentech.lecture.retrofit.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

import com.faisal.peoplentech.lecture.retrofit.internet.ConnectionDetector;

public class WifiReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        try
        {
            if (ConnectionDetector.getInstance(context).isNetAvailable()) {

                Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
            } else {

                Toast.makeText(context, "Intent lost.", Toast.LENGTH_LONG).show();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
