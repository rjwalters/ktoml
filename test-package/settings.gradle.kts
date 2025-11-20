rootProject.name = "test-package"

pluginManagement {
    repositories {
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
    }
}
