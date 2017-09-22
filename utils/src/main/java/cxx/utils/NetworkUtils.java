package cxx.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.widget.Toast;

public class NetworkUtils {
	
	  // ÎÞÍøÂç
    public final static int NONE = 0;
    // Wi-Fi
    public final static int WIFI = 1;
    // 3G,GPRS
    public final static int MOBILE = 2;
	
	public static int getNetworkState(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        State state = connManager.getNetworkInfo(
                ConnectivityManager.TYPE_MOBILE).getState();
        if (state == State.CONNECTED || state == State.CONNECTING) {
            return MOBILE;
        }

        state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        if (state == State.CONNECTED || state == State.CONNECTING) {
            return WIFI;
        }
        return NONE;
    }

    public static boolean isNetWorkValid(Context context, boolean isShowPrompt) {
        boolean isValid = getNetworkState(context) != NONE;
        if (!isValid && isShowPrompt) {
            String prompt = context.getResources().getString(R.string.network_err);
            Toast.makeText(context, prompt, Toast.LENGTH_SHORT).show();
        }
        return isValid;
    }

    public static boolean isNetWorkValid(Context context) {
        return isNetWorkValid(context, false);
    }

}
