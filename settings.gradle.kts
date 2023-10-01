import java.net.URI

include(":sharedkmm")


pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()    // no need to declare this in `allProjects` if its declared here
        mavenCentral()
        maven { url = URI("https://jitpack.io") }
    }
}

rootProject.name = "Oleg Money"
include(":app")
