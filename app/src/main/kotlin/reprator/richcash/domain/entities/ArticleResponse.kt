package reprator.richcash.domain.entities

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import kotlinx.android.parcel.Parcelize
import java.util.*


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    "status",
    "totalResults",
    "articles"
)
@Parcelize
class ArticleResponse(
    @JsonProperty("status") val status: String,
    @JsonProperty("totalResults") val totalResults: Int,
    @JsonProperty("articles") val articles: List<Article>
) : Parcelable


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    "source",
    "author",
    "title",
    "description",
    "url",
    "urlToImage",
    "publishedAt",
    "content"
)
@Parcelize
class Article(
    @JsonProperty("source") val source: Source, @JsonProperty("author") val author: String? = "",
    @JsonProperty("title") val title: String, @JsonProperty("description") val description: String? = "",
    @JsonProperty("url") val url: String, @JsonProperty("urlToImage") val urlToImage: String? = "",
    @JsonProperty("publishedAt") val publishedAt: Date, @JsonProperty("content") val content: String? = ""
) : Parcelable


@Parcelize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "name")
public class Source(
    @JsonProperty("id") val id: String?, @JsonProperty("name") val name: String
) : Parcelable