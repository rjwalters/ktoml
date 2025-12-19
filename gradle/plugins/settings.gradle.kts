pluginManagement {
    repositories {
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
        gradlePluginPortal()
        maven {
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        }
    }
}

rootProject.name = "plugins"
