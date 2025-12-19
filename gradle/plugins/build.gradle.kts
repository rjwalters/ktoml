import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

repositories {
    maven {
        url = uri("https://repo1.maven.org/maven2/")
    }
    gradlePluginPortal()
    maven {
        url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
}

dependencies {
    implementation("io.github.gradle-nexus:publish-plugin:2.0.0")
}
