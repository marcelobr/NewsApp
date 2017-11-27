package com.example.android.newsapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by marcelo on 27/11/17.
 */

public class ConnectionUtils {

    private static final String LOG_TAG = ConnectionUtils.class.getSimpleName();

    private ConnectionUtils() {
    }

    public static boolean isOnline(Context context) {
        boolean status = false;
        try {
            // Get a reference to the ConnectivityManager to check state of network connectivity
            ConnectivityManager connMgr = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            // Get details on the currently active default data network
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            status = networkInfo != null && networkInfo.isConnected();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Problem retrieving the news JSON results.", e);
        }

        return status;
    }
}
