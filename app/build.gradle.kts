import com.android.build.gradle.api.ApplicationVariant
import com.android.build.gradle.api.BaseVariantOutput
import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

plugins {
    id(Libs.androidApplication)
    id(Libs.kotlinAndroid)
    id(Libs.kotlinAndroidExtensions)
    id(Libs.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        applicationId = AppConstant.applicationPackage
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = AppVersion.versionCode
        versionName = AppVersion.versionName
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        // resConfigs("en", "ja")

        resConfig("en")
        buildConfigField("String", AppConstant.hostConstant, "\"${AppConstant.host}\"")
        buildConfigField("String", AppConstant.NewsApiConstant, "\"${AppConstant.NewsApiKey}\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    buildTypes {

        getByName("debug") {
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }

        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            isUseProguard = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }


        applicationVariants.all(object : Action<ApplicationVariant> {
            override fun execute(variant: ApplicationVariant) {
                variant.outputs.all(object : Action<BaseVariantOutput> {
                    override fun execute(output: BaseVariantOutput) {
                        val outputImpl = output as BaseVariantOutputImpl
                        val fileName = "${variant.name.capitalize()}-${AppConstant.name}.apk"
                        //val fileName = "${variant.name.capitalize()}-${versionName}.apk"
                        outputImpl.outputFileName = fileName

                        // output.outputFileName = "${project.PROJECT_APK_NAME}_${variant.productFlavors[0].name}_${versionName}.apk"
                    }
                })
            }
        })
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin/")
    }

    testOptions {
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    dataBinding.isEnabled = true
}

androidExtensions {
    isExperimental = true
    configure(delegateClosureOf<AndroidExtensionsExtension> {
        isExperimental = true
    })
}

/*androidExtensions.isExperimental = true*/


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Google.material)
    implementation(Libs.AndroidX.recyclerview)
    implementation(Libs.AndroidX.annotation)
    implementation(Libs.AndroidX.cardView)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.constraintlayout)
    implementation(Libs.AndroidX.multidex)

    implementation(Libs.AndroidX.Lifecycle.extensions)
    implementation(Libs.AndroidX.Lifecycle.runtime)
    implementation(Libs.AndroidX.Lifecycle.viewmodel)
    implementation(Libs.AndroidX.Paging.runtime)

    kapt(Libs.AndroidX.Lifecycle.compiler)

    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.jacksonConverter)
    implementation(Libs.OkHttp.loggingInterceptor)

    implementation(Libs.timber)

    implementation(Libs.Kodein.jvm)
    implementation(Libs.Kodein.androidX)
    implementation(Libs.Kodein.androidCore)

    implementation(Libs.Glide.glide)
    annotationProcessor(Libs.Glide.annotationProcessor)

//  androidTestImplementation(Libs.AndroidX.Test.mockitoKotlin)
    androidTestImplementation(Libs.AndroidX.Test.runner)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
    testImplementation(Libs.AndroidX.Test.junit)
}

