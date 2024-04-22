plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.plugin.android)
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.kotlinter)
    implementation(libs.plugin.google.ksp)
}
gradlePlugin {
    plugins {
        register("androidLibraryJacoco") {
            id = "androidcomposeapp.android.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }
    }
}
