plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = libs.versions.nameSpaceData.get()
    compileSdk = 34

    defaultConfig {
        minSdk = 29
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
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.java.sdk.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.java.sdk.get())
    }
    kotlinOptions {
        jvmTarget = libs.versions.java.sdk.get()
    }
}

dependencies {
    implementation(projects.domainLayer)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    // implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.testExtJunit)
    // androidTestImplementation(libs.androidx.testEspressoCore)
}
