package reprator.richcash.retrofitNetwork.retrofit

import reprator.richcash.domain.entities.ArticleResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("top-headlines")
    fun getAllImages(
        @Query("country") countryCode: String, @Query("apiKey") apiKey: String,
        @Query("page") page: Int, @Query("pageSize") perPage: Int
    ): Call<ArticleResponse>
}


/*

https://newsapi.org/v2/top-headlines?country=in&apiKey=ca6450ec15e14090835fbc2267b05a41&page=3&pageSize=20*/
