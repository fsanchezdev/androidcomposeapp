plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id(libs.plugins.dagger.hilt.get().pluginId)
    alias(libs.plugins.compose.compiler)
    id("conventions.android")
}

android {
    namespace = libs.versions.nameSpacePresentation.get()
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    // TODO add dokka to documentate app
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.java.sdk.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.java.sdk.get())
    }
    kotlinOptions {
        jvmTarget = libs.versions.java.sdk.get()
    }
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler_metrics")
    metricsDestination = layout.buildDirectory.dir("compose_compiler_metrics")
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(projects.domainLayer)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    // implementation(libs.material)
    testImplementation(libs.junit)
    // androidTestImplementation(libs.androidx.testextjunit)
    // androidTestImplementation(libs.androidx.testEspressoCore)
    testImplementation(libs.square.turbine)
    implementation(libs.androidx.coreSplashscreen)
    implementation(libs.google.daggerHiltAndroid)
}
