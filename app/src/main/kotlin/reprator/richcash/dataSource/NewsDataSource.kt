package reprator.richcash.dataSource

import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import reprator.richcash.domain.entities.Article
import reprator.richcash.domain.interactor.news.NewsRequestBody
import reprator.richcash.domain.interactor.news.NewsUseCase
import reprator.richcash.domain.interactor.Result

class NewsDataSource(
    val countryCode: String, val coroutineScope: CoroutineScope,
    val newsUseCase: NewsUseCase
) : PageKeyedDataSource<Int, Article>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Article>) {

        val newsRequestBody = NewsRequestBody(countryCode)
        newsUseCase.stockDataSource.newsList(newsRequestBody)

        newsUseCase.execute(coroutineScope, newsRequestBody) {
            when (it) {
                is Result.Success -> {
                    callback.onResult(it.data, null, newsRequestBody.page)
                }
                is Result.Error -> {
                    /* handleError(it.exception)*/
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {

        val newsRequestBody = NewsRequestBody(countryCode, page = params.key + 1)
        newsUseCase.execute(coroutineScope, newsRequestBody) {
            when (it) {
                is Result.Success -> {
                    callback.onResult(it.data, newsRequestBody.page)
                }
                is Result.Error -> {
                    /* handleError(it.exception)*/
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
