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

    // For compose compiler build snapshots.
    maven("https://androidx.dev/storage/compose-compiler/repository/") {
      content {
        includeGroup("androidx.compose.compiler")
      }
    }
  }
}

plugins {
  // `gradle-enterprise` remove?
  id("conventions")
}
/*
gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}
*/
