enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "androidcomposeapp"

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("android.arch.*")
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("com.android.*")
                includeGroupByRegex("com.google.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google {
            content {
                includeGroupByRegex("android.arch.*")
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("com.android.*")
                includeGroupByRegex("com.google.*")
            }
        }
        mavenCentral()

        // Enable only if jitpack is required.
        //
        // maven("https://jitpack.io") {
        //     content {
        //         includeGroupByRegex("com.github.*")
        //     }
        // }
    }
}

plugins {
    id("com.gradle.develocity") version "3.19.2"
    id("conventions")
}

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/terms-of-service"
        termsOfUseAgree = "yes"
    }
}

