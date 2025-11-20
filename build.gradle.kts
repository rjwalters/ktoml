import com.akuleshov7.buildutils.*
import com.saveourtool.diktat.plugin.gradle.DiktatExtension
import com.saveourtool.diktat.plugin.gradle.DiktatGradlePlugin

plugins {
    kotlin("multiplatform") apply false
    kotlin("plugin.serialization") version Versions.KOTLIN apply false
    id("com.akuleshov7.buildutils.publishing-configuration")
    id("com.saveourtool.diktat") version "2.0.0"
}

// Disable Reckon automatic versioning for fork - it doesn't handle the version jump from upstream
// configureVersioning()

// Set fixed version for fork releases
version = "0.8.2-rjwalters"

allprojects {
    repositories {
        maven {
            url = uri("https://repo1.maven.org/maven2/")
        }
    }

    apply<DiktatGradlePlugin>()

    configure<DiktatExtension> {
        diktatConfigFile = rootProject.file("diktat-analysis.yml")
        githubActions = findProperty("diktat.githubActions")?.toString()?.toBoolean() ?: false
        inputs {
            // using `Project#path` here, because it must be unique in gradle's project hierarchy
            if (path == rootProject.path) {
                include("$rootDir/buildSrc/src/**/*.kt", "$rootDir/*.kts", "$rootDir/buildSrc/**/*.kts")
                exclude("src/test/**/*.kt", "src/commonTest/**/*.kt")  // path matching this pattern will not be checked by diktat
            } else {
                include("src/**/*.kt", "**/*.kts")
                exclude("src/**test/**/*.kt", "src/commonTest/**/*.kt", "src/jvmTest/**/*.kt")  // path matching this pattern will not be checked by diktat
            }
        }
        debug = true
        reporters {
            plain()
        }
    }

    configureDetekt()
}

createDetektTask()
installGitHooks()

// Create a convenient 'test' task alias for 'allTests'
tasks.register("test") {
    group = "verification"
    description = "Runs all tests (alias for allTests)"
    dependsOn("allTests")
}
