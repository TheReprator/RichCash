object AndroidSdk {
    const val min = 15
    const val compile = 28
    const val target = compile
}

object AppConstant {
    const val applicationPackage = "reprator.richcash"
    const val host = "https://newsapi.org/v2/"
    const val hostConstant = "HOST"
    const val name = "CashRich"
    const val NewsApiConstant = "apiKey"
    const val NewsApiKey = "ca6450ec15e14090835fbc2267b05a41"
}

object AppVersion {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Libs {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"

    val androidGradlePlugin = "com.android.tools.build:gradle:3.5.0-alpha10"
    val dexcountGradlePlugin = "com.getkeepsafe.dexcount:dexcount-gradle-plugin:0.8.6"
    val playPublisherPlugin = "com.github.triplet.gradle:play-publisher:2.1.0"

    val mvRx = "com.airbnb.android:mvrx:0.7.2"

    val threeTenBp = "org.threeten:threetenbp:1.3.8"
    val threeTenBpNoTzdb = "$threeTenBp:no-tzdb"
    val threeTenAbp = "com.jakewharton.threetenabp:threetenabp:1.1.2"

    val gravitySnapHelper = "com.github.rubensousa:gravitysnaphelper:2.0"
    val crashLytics = "com.crashlytics.sdk.android:crashlytics:2.9.6"

    val rxLint = "nl.littlerobots.rxlint:rxlint:1.7.3"

    val timber = "com.jakewharton.timber:timber:4.7.1"
    val caligraphy = "uk.co.chrisjenx:calligraphy:2.3.0"

    val tmdbJava = "com.uwetrottmann.tmdb2:tmdb-java:2.0.1"

    val appauth = "net.openid:appauth:0.7.1"

    object Google {
        val material = "com.google.android.material:material:1.1.0-alpha04"
        val firebaseCore = "com.google.firebase:firebase-core:16.0.7"
        val crashlytics = "com.crashlytics.sdk.android:crashlytics:2.9.9"
        val gmsGoogleServices = "com.google.gms:google-services:4.2.0"
        val fabricPlugin = "io.fabric.tools:gradle:1.27.1"
    }

    object Firebase {
        val code = "com.google.firebase:firebase-core:16.0.7"
        val iid = "com.google.firebase:firebase-iid:17.1.0"
        val messaging = "com.google.firebase:firebase-messaging:17.4.0"
    }

    object Kotlin {
        private const val version = "1.3.21"
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.1.1"
        val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        val rx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"
        val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object AndroidX {
        val appcompat = "androidx.appcompat:appcompat:1.0.2"
        val browser = "androidx.browser:browser:1.0.0"
        val palette = "androidx.palette:palette:1.0.0"
        val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"
        val cardView = "androidx.cardview:cardview:1.0.0"
        val annotation = "androidx.annotation:annotation:1.0.0-alpha1"
        val emoji = "androidx.emoji:emoji:1.0.0"
        val multidex = "androidx.multidex:multidex:2.0.1"
        val preference = "androidx.preference:preference:1.1.0-alpha02"
        val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-alpha3"
        val coreKtx = "androidx.core:core-ktx:1.0.1"

        object Fragment {
            private const val version = "1.1.0-alpha03"
            val fragment = "androidx.fragment:fragment:$version"
            val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Test {
            val core = "androidx.test:core:1.1.0"
            val runner = "androidx.test:runner:1.1.1"
            val rules = "androidx.test:rules:1.1.1"

            val junit = "junit:junit:4.12"
            val robolectric = "org.robolectric:robolectric:4.2"
            val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"

            val espressoCore = "androidx.test.espresso:espresso-core:3.1.1"
        }

        val archCoreTesting = "androidx.arch.core:core-testing:2.0.0"

        object Paging {
            private const val version = "2.1.0"
            val common = "androidx.paging:paging-common:$version"
            val runtime = "androidx.paging:paging-runtime:$version"
            val rxjava2 = "androidx.paging:paging-rxjava2:$version"
        }

        object Lifecycle {
            private const val version = "2.1.0-alpha03"
            val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
            val runtime = "androidx.lifecycle:lifecycle-runtime:$version"
            val viewmodel = "androidx.lifecycle:lifecycle-viewmodel:$version"
        }

        object Room {
            private const val version = "2.0.0"
            val common = "androidx.room:room-common:$version"
            val runtime = "androidx.room:room-runtime:$version"
            val rxjava2 = "androidx.room:room-rxjava2:$version"
            val compiler = "androidx.room:room-compiler:$version"
        }

        object Work {
            private const val version = "1.0.0-rc01"
            val runtimeKtx = "android.arch.work:work-runtime-ktx:$version"
        }
    }

    object RxJava {
        val rxJava = "io.reactivex.rxjava2:rxjava:2.2.6"
        val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
        val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }

    object Kodein {
        private const val version = "6.0.1"
        val jvm = "org.kodein.di:kodein-di-generic-jvm:$version"
        val androidX = "org.kodein.di:kodein-di-framework-android-x:$version"
        val androidCore = "org.kodein.di:kodein-di-framework-android-core:$version"
    }

    object Glide {
        private const val version = "4.9.0"
        val glide = "com.github.bumptech.glide:glide:$version"
        val annotationProcessor = "com.github.bumptech.glide:compiler:$version"
    }

    object Retrofit {
        private const val version = "2.5.0"
        val retrofit = "com.squareup.retrofit2:retrofit:$version"
        val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        val jacksonConverter = "com.squareup.retrofit2:converter-jackson:$version"
    }

    object OkHttp {
        val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.14.0"
    }

    object Epoxy {
        private const val version = "3.3.0"
        val epoxy = "com.airbnb.android:epoxy:$version"
        val paging = "com.airbnb.android:epoxy-paging:$version"
        val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        val processor = "com.airbnb.android:epoxy-processor:$version"
    }

    object AssistedInject {
        private const val version = "0.3.2"
        val annotationDagger2 = "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
        val processorDagger2 = "com.squareup.inject:assisted-inject-processor-dagger2:$version"
    }


    // Test Libraries
    const val androidSupportRules = "1.0.0"
    const val androidSupportRunner = "1.0.0"
    const val assertJ = "3.8.0"
    const val dexmakerMockito = "2.16.0"
    const val dexopener = "0.12.1"
    const val espresso = "3.0.1"
    const val jUnit = "4.12"
    const val mockitoKotlin = "1.5.0"
    const val robolectric = "3.4.2"
    const val runner = "0.5"

    object TestDependencies {

        const val androidRules = "com.android.support.test:rules:${Libs.runner}"
        const val androidRunner = "com.android.support.test:runner:${Libs.runner}"
        const val assertj = "org.assertj:assertj-core:${Libs.assertJ}"
        const val dexmakerMockito = "com.linkedin.dexmaker:dexmaker-mockito:${Libs.dexmakerMockito}"
        const val dexopener = "com.github.tmurakami:dexopener:${Libs.dexopener}"
        const val espressoContrib = "com.android.support.test.espresso:espresso-contrib:${Libs.espresso}"
        const val espressoCore = "com.android.support.test.espresso:espresso-core:${Libs.espresso}"
        const val espressoIntents = "com.android.support.test.espresso:espresso-intents:${Libs.espresso}"
        const val junit = "junit:junit:${Libs.jUnit}"
        const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:2.1.0"
        const val mockitoKotlin = "com.nhaarman:mockito-kotlin:${Libs.mockitoKotlin}"
        const val robolectric = "org.robolectric:robolectric:${Libs.robolectric}"
        const val roomTesting = "android.arch.persistence.room:testing:2.0.0"
        const val supportRules = "com.android.support.test:rules:${Libs.androidSupportRules}"
        const val supportRunner = "com.android.support.test:runner:${Libs.androidSupportRunner}"
    }
}
