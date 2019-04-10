package reprator.richcash

import android.app.Application
import androidx.annotation.VisibleForTesting
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import reprator.richcash.di.appModule
import timber.log.Timber

class RichCash : Application(), KodeinAware {

    private val timberTree by instance<Timber.Tree>()

    @VisibleForTesting
    var overrideBindings: Kodein.MainBuilder.() -> Unit = {}

    override val kodein = Kodein.lazy {
        import(appModule(applicationContext))
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(timberTree)
    }
}
