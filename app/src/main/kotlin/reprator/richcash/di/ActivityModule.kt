package reprator.richcash.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

fun baseActivityModule(activity: AppCompatActivity) = Kodein.Module("activityModule") {
  bind<Context>(overrides = true) with provider { activity }
}
