package reprator.richcash.di

import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import reprator.richcash.retrofitNetwork.retrofit.apiModule
import reprator.richcash.retrofitNetwork.retrofit.fileModule
import reprator.richcash.retrofitNetwork.retrofit.networkModule
import reprator.richcash.utils.NetworkUtils
import timber.log.Timber

fun appModule(appContext: Context) = Kodein.Module("appModule") {
    bind<Context>("appContext") with provider { appContext }
    bind<Timber.Tree>() with provider { Timber.DebugTree() }
    bind<NetworkUtils>("networkUtils") with provider { NetworkUtils(instance("appContext")) }

    import(fileModule(appContext))
    import(networkModule)
    import(apiModule)
}