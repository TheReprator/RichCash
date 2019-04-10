package reprator.richcash.presentation.newsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import reprator.richcash.dataSource.NewsDataSourceFactory
import reprator.richcash.domain.entities.Article
import reprator.richcash.domain.interactor.news.NewsUseCase
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class NewsViewModal constructor(val countryCode: String, newsUseCase: NewsUseCase) : ViewModel(),
    CoroutineScope {

    val job: Job

    init {
        job = Job()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    var error: MutableLiveData<String> = MutableLiveData()

    var newsLiveData: LiveData<PagedList<Article>>
    var newsDataSource: LiveData<PageKeyedDataSource<Int, Article>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()

        val newsDataSourceFactory: NewsDataSourceFactory = NewsDataSourceFactory(countryCode, this, newsUseCase)
        newsDataSource = newsDataSourceFactory.mutableDataSource
        newsLiveData = LivePagedListBuilder(newsDataSourceFactory, config).build()
    }

    protected fun handleError(error: Exception) {
        this.error.value = error.localizedMessage
    }


    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}