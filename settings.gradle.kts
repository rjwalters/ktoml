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

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("1.0.0")
}

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
        maven {
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
        }
    }
}

rootProject.name = "ktoml"

includeBuild("gradle/plugins")
include("ktoml-core")
include("ktoml-file")
include("ktoml-source")
