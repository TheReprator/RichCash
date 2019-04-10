package reprator.richcash.retrofitNetwork.retrofit

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

val apiModule = Kodein.Module(name = "apiModule") {

    bind<ObjectMapper>() with provider {
        val httpLoggingInterceptor = ObjectMapper()
        httpLoggingInterceptor.apply {
            disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
            disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        }
    }

    bind<Retrofit>() with provider {
        val retrofitBuilder = Retrofit.Builder().apply() {
            baseUrl(instance<String>(tag = BASE_URL))
            addConverterFactory(JacksonConverterFactory.create(instance()))
            client(instance<OkHttpClient>())
        }
        retrofitBuilder.build()
    }

    bind<ApiService>() with singleton {
        instance<Retrofit>().create(ApiService::class.java)
    }
}