pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
rootProject.name = "MoviesApp"
include(":app")
include(":feature:home")
include(":common")
include(":feature:details")
include(":feature:search")
