package reprator.richcash.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import reprator.richcash.R
import reprator.richcash.presentation.newsList.NewsListFragment
import reprator.richcash.utils.doTransaction

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpToolbar()

        supportFragmentManager.doTransaction {
            replace(R.id.ac_container, NewsListFragment.newInstance())
        }
    }

    private fun setUpToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.ac_toolBar).also {
            it.setTitle(resources.getString(R.string.app_name))
        }
        setSupportActionBar(toolbar)
    }
}