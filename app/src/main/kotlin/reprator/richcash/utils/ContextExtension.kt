package reprator.richcash.utils

import android.content.Context
import android.telephony.TelephonyManager

fun Context.getCountryCode(): String {
    val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telephonyManager.getSimCountryIso()
}
