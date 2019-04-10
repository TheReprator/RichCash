package reprator.richcash.dataSource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import reprator.richcash.domain.entities.Article
import reprator.richcash.domain.interactor.news.NewsUseCase

class NewsDataSourceFactory(
    private val countryCode: String, private val coroutineScope: CoroutineScope,
    private val newsUseCase: NewsUseCase
) : DataSource.Factory<Int, Article>() {

    public val mutableDataSource = MutableLiveData<PageKeyedDataSource<Int, Article>>()

    override fun create(): DataSource<Int, Article> {
        val dataSource = NewsDataSource(countryCode, coroutineScope, newsUseCase)
        mutableDataSource.postValue(dataSource)
        return dataSource
    }
}
