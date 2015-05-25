package edu.osu.expandablelistviewtest1.customclasses;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class WifiConnectionChecker {
    public static boolean connectedToWifi(Context c) {
        // http://stackoverflow.com/questions/3841317/how-to-see-if-wifi-is-connected-in-android
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConnection = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return(wifiConnection.isConnected());
    }
}
