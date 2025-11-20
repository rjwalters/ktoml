plugins {
    kotlin("jvm") version "2.2.21"
    `maven-publish`
}

group = "com.akuleshov7"
version = "0.0.1-test"

dependencies {
    implementation(kotlin("stdlib"))
}

kotlin {
    jvmToolchain(17)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/rjwalters/ktoml")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.akuleshov7"
            artifactId = "test-package"
            version = "0.0.1-test"
        }
    }
}
