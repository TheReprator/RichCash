package reprator.richcash.presentation.newsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import reprator.richcash.R
import reprator.richcash.domain.entities.Article

class NewsAdapter :
    PagedListAdapter<Article, NewsAdapter.NewsViewHolder>(object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article) = oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Article, newItem: Article) = oldItem.title == newItem.title

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_news,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)

        Glide.with(holder.newImageView)
            .load(news?.urlToImage).placeholder(R.mipmap.ic_launcher).into(holder.newImageView)

        holder.newsTitle.text = news?.title
        holder.newsAuthorName.text = news?.author ?: ""
    }


    class NewsViewHolder(itemView1: View) : RecyclerView.ViewHolder(itemView1) {

        val newImageView: ImageView = itemView1.findViewById(R.id.ac_news_banner)
        val newsTitle: TextView = itemView1.findViewById(R.id.ac_news_title)
        val newsAuthorName: TextView = itemView1.findViewById(R.id.ac_news_authorName)
    }

}


