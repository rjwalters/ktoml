pluginManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
            content {
                includeGroupByRegex("org\\.jetbrains.*")
            }
        }
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("1.0.0")
}

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
            content {
                includeGroupByRegex("org\\.jetbrains.*")
            }
        }
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
    }
}

rootProject.name = "ktoml"

includeBuild("gradle/plugins")
include("ktoml-core")
include("ktoml-file")
include("ktoml-source")
