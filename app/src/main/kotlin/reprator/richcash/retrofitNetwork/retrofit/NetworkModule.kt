package reprator.richcash.retrofitNetwork.retrofit

import android.content.Context
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.bindings.Singleton
import org.kodein.di.generic.*
import reprator.richcash.BuildConfig
import reprator.richcash.retrofitNetwork.http.httpClient
import reprator.richcash.retrofitNetwork.interceptors.CacheInterceptor
import reprator.richcash.retrofitNetwork.interceptors.OfflineCacheInterceptor
import reprator.richcash.retrofitNetwork.interceptors.loggingInterceptor
import java.io.File

const val BASE_URL = "serverURL"
const val IS_DEBUG = "isDebug"
const val RETROFIT_CONNECTION_TIME = "timeOut"

val networkModule = Kodein.Module(name = "netWorkModule") {

    constant(tag = IS_DEBUG) with BuildConfig.DEBUG
    constant(tag = BASE_URL) with BuildConfig.HOST
    constant(tag = RETROFIT_CONNECTION_TIME) with 90L

    constant(tag = "totalDaysCaching") with 3

    import(cacheModule())

    bind<Interceptor>(tag = "cachingInterceptor") with singleton {
        CacheInterceptor(instance(tag = "totalDaysCaching"))
    }

    bind<Interceptor>(tag = "offlineInterceptor") with singleton {
        OfflineCacheInterceptor(instance(tag = "totalDaysCaching"), instance("networkUtils"))
    }

    bind<HttpLoggingInterceptor>(tag = "lodginInterceptor") with singleton {
        loggingInterceptor().apply {
            level = if (instance(IS_DEBUG))
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    bind<OkHttpClient>() with singleton {
        httpClient(
            instance(tag = "lodginInterceptor"), instance("cachingInterceptor"),
            instance("offlineInterceptor"), instance()
        )
    }
}

fun cacheModule() = Kodein.Module("cacheModule") {
    constant(tag = "totalCacheSize") with (10 * 1024 * 1024).toLong()

    bind<Cache>() with provider { Cache(instance<File>("fileCache"), instance(tag = "totalCacheSize")) }
}

fun fileModule(context: Context) = Kodein.Module("fileModule") {
    bind<File>(tag = "fileCache") with provider { File(context.cacheDir, "RichCash_offlineCache") }
}
