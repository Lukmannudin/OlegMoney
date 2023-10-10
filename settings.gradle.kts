import java.net.URI

include(":sharedkmm")


pluginManagement {
      resolutionStrategy {
            eachPlugin {
                  if (requested.id.id == "com.squareup.wire") {
                        // For some reason, Gradle does a lookup on the wrong coordinates:
                        // 'com.squareup.wire:com.squareup.wire.gradle.plugin' instead of the one below.
                        useModule("com.squareup.wire:wire-gradle-plugin:${requested.version}")
                      }
                }
          }
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
