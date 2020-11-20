package com.faisal.peoplentech.lecture.retrofit.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class WifiReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
     /*   if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)) {
            if (intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false)) {
                //do stuff
                Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
            } else {
                // wifi connection was lost
                Toast.makeText(context, "Intent lost.", Toast.LENGTH_LONG).show();
            }
        }*/

        NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        if(info != null && info.isConnected()) {
            // Do your work.
            Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
            // e.g. To check the Network Name or other info:
            WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            String ssid = wifiInfo.getSSID();
        }else {
            // wifi connection was lost
            Toast.makeText(context, "Intent lost.", Toast.LENGTH_LONG).show();
        }
    }
}
