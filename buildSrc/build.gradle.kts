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
    // Use compatible Kotlin Gradle Plugin version
    implementation(platform("org.jetbrains.kotlin:kotlin-gradle-plugins-bom:2.2.20"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.20")

    // Diktat - use latest available version
    implementation("com.saveourtool.diktat:diktat-gradle-plugin:2.0.0")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.8")
    implementation("io.github.gradle-nexus:publish-plugin:2.0.0")
    // Reckon and grgit - use latest available versions
    implementation("org.ajoberstar.reckon:reckon-gradle:0.19.1")
    implementation("org.ajoberstar.grgit:grgit-core:5.3.0")
}
