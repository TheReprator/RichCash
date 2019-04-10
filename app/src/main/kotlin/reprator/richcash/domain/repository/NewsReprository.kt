package reprator.richcash.domain.repository

import reprator.richcash.domain.entities.Article
import reprator.richcash.retrofitNetwork.retrofit.ApiService
import reprator.richcash.domain.interactor.Result
import reprator.richcash.domain.interactor.news.NewsRequestBody
import java.io.IOException

class NewsReprository(val apiService: ApiService) : NewsDataSource {

    override fun newsList(newsRequestBody: NewsRequestBody): Result<List<Article>> = safeApiCall(
        call = { requestNewsList(newsRequestBody) },
        errorMessage = "Error getting stocks"
    )

    private fun requestNewsList(newsRequestBody: NewsRequestBody): Result<List<Article>> {

        val response = apiService.getAllImages(
            newsRequestBody.countryCode, newsRequestBody.apiKey,
            newsRequestBody.page, newsRequestBody.pagePerSize
        ).execute()

        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                return Result.Success(body.articles)
            }
        }

        return Result.Error(IOException("Error getting stocks ${response.code()} ${response.message()}"))
    }

    fun <T> safeApiCall(call: () -> Result<T>, errorMessage: String): Result<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            Result.Error(IOException(errorMessage, e))
        }
    }

}