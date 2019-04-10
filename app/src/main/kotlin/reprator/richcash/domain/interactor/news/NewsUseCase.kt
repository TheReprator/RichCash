package reprator.richcash.domain.interactor.news

import reprator.richcash.BuildConfig
import reprator.richcash.domain.entities.Article
import reprator.richcash.domain.interactor.Result
import reprator.richcash.domain.interactor.UseCase
import reprator.richcash.domain.repository.NewsDataSource

class NewsUseCase(var stockDataSource: NewsDataSource) : UseCase<List<Article>, NewsRequestBody>() {
    override suspend fun run(params: NewsRequestBody): Result<List<Article>> =
        stockDataSource.newsList(params)
}


class NewsRequestBody(
    val countryCode: String,
    val apiKey: String = BuildConfig.apiKey,
    val page: Int = 1,
    val pagePerSize: Int = 20
) : UseCase.NoParams()
