# AndroidComposeApp

## App with compose to explore and learn new features

This project uses the following characteristics:

- 3 Layers: 
    - Data
    - Domain
    - Presentation
        - Compose UI
- JDK20 toolchain
- 100% Kotlin (no 'java' dirs)
- 100% Jetpack Compose (no fragments)
- LeakCanary
- Gradle convention plugins
- Gradle version catalog
- Gradle typesafe project accessors
    - Mend Renovate configuration
- Github action to run checks on every push/PR
- Renovate tool to keep dependencies up to date
- Dagger + Hilt
- Single activity with
    - Splashscreen
    - Edge to edge layout
    - Compose Material 3 Theme with palette generated from http://m3.material.io
    - androidx NavHost for navigation

