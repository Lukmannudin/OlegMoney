import java.net.URI

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()    // no need to declare this in `allProjects` if its declared here
        mavenCentral()
        maven { url = URI("https://jitpack.io") }
    }
}

rootProject.name = "Oleg Money"
include(":app")