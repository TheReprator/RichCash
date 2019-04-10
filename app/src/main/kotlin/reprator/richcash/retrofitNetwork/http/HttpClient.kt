package reprator.richcash.retrofitNetwork.http

import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient

fun httpClient(
    loggingInterceptor: Interceptor,
    cacheInterceptor: Interceptor,
    offlineInterceptor: Interceptor,
    cache: Cache
): OkHttpClient =

    OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor).apply {
        addInterceptor(loggingInterceptor)
        addInterceptor(offlineInterceptor)
        addNetworkInterceptor(cacheInterceptor)
        cache(cache)
    }.build()
