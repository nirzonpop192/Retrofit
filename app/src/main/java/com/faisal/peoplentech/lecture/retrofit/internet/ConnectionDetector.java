package com.faisal.peoplentech.lecture.retrofit.internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector  {

    private static ConnectionDetector mInstance = null;

    private Context mContext;

    private ConnectionDetector() {
    }

    private ConnectionDetector(Context mContext) {
        this.mContext = mContext;
    }

    public static ConnectionDetector getInstance(Context mContext) {
        if (mInstance == null)
            mInstance = new ConnectionDetector(mContext);
        return mInstance;

    }


    public boolean isNetAvailable() {
        ConnectivityManager manager = (ConnectivityManager) mContext.getSystemService
                (Context.CONNECTIVITY_SERVICE);

        if (manager != null) {
            NetworkInfo[] netInfo = manager.getAllNetworkInfo();
            if (netInfo != null) {
                for (NetworkInfo info : netInfo) {
                    if (info.getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }
}