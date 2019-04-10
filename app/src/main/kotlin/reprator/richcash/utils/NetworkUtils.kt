package reprator.richcash.utils

import android.content.Context
import android.net.ConnectivityManager


public class NetworkUtils(val context: Context) {

    public fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected)
    }
}
