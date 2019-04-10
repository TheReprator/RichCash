package reprator.richcash.domain.repository

import reprator.richcash.domain.entities.Article
import reprator.richcash.domain.interactor.Result
import reprator.richcash.domain.interactor.news.NewsRequestBody

interface NewsDataSource {
    fun newsList(newsRequestBody: NewsRequestBody): Result<List<Article>>
}
