package reprator.richcash.presentation.newsList


import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import reprator.richcash.R
import reprator.richcash.domain.entities.Article
import reprator.richcash.presentation.newsList.di.newsListModule

class NewsListFragment : Fragment(), KodeinAware {

    companion object {
        fun newInstance() = NewsListFragment()
    }

    override val kodein: Kodein = Kodein.lazy {
        val activityKodein by closestKodein(context!!)
        extend(activityKodein)
        import(newsListModule(context!!))
    }

    private val newsViewModal: NewsViewModal by instance()
    private val newsAdapter: NewsAdapter by lazy {
        NewsAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return  inflater.inflate(R.layout.fragment_newslist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.ac_newsList)
        with(recyclerView)
        {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            addItemDecoration(MarginItemDecoration(resources.getDimension(R.dimen.default_padding).toInt()))
        }

        newsViewModal.newsLiveData.observe(this, object : Observer<PagedList<Article>> {
            override fun onChanged(t: PagedList<Article>?) {
                newsAdapter.submitList(t)
            }
        })

        recyclerView.adapter = newsAdapter
    }

    class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View,
                                    parent: RecyclerView, state: RecyclerView.State) {

            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceHeight
                }
                left =  spaceHeight
                right = spaceHeight
                bottom = spaceHeight
            }
        }
    }
}