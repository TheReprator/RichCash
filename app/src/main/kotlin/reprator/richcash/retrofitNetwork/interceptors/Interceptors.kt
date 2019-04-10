package reprator.richcash.retrofitNetwork.interceptors

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import reprator.richcash.utils.NetworkUtils
import timber.log.Timber
import java.util.concurrent.TimeUnit

const val HEADER_CACHE_CONTROL = "Cache-Control"
const val HEADER_PRAGMA = "Pragma"

class CacheInterceptor(val maxCacheStoreDays: Int) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val cacheControl = CacheControl.Builder()
            .maxAge(maxCacheStoreDays, TimeUnit.DAYS)
            .build();

        val response = chain.proceed(chain.request())
        return response.newBuilder()
            .header(HEADER_CACHE_CONTROL, cacheControl.toString())
            .removeHeader(HEADER_PRAGMA)
            .build()
    }
}


class OfflineCacheInterceptor(val maxCacheStoreDays: Int, val networkUtils: NetworkUtils) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!networkUtils.isNetworkAvailable()) {

            val cacheControl = CacheControl.Builder()
                .onlyIfCached()
                .maxStale(maxCacheStoreDays, TimeUnit.DAYS)
                .build();

            val offlineRequest = chain.request().newBuilder()
                .cacheControl(cacheControl)
                .removeHeader(HEADER_PRAGMA)
                .build();
            return chain.proceed(offlineRequest);
        }
        return chain.proceed(chain.request())
    }
}


fun loggingInterceptor() = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        Timber.i(message);
    }
})
