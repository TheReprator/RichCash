package reprator.richcash.presentation.newsList.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import reprator.richcash.domain.interactor.news.NewsUseCase
import reprator.richcash.domain.repository.NewsDataSource
import reprator.richcash.domain.repository.NewsReprository
import reprator.richcash.presentation.newsList.NewsViewModal
import reprator.richcash.utils.getCountryCode
import reprator.richcash.utils.getViewModel


fun newsListModule(context: Context) = Kodein.Module("newsListDI") {
    bind<String>("countryCode") with provider { context.getCountryCode() }
    bind<NewsDataSource>() with provider { NewsReprository(instance()) }
    bind<NewsUseCase>() with provider { NewsUseCase(instance()) }

    bind<NewsViewModal>() with provider {
        (context as AppCompatActivity).getViewModel { NewsViewModal(instance("countryCode"), instance()) }
    }
}
