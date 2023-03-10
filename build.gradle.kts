import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.serialization") version "1.7.21"
    `maven-publish`
    application
}

group = "com.aseemsavio.dynamokt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

}

dependencies {
    // https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk-dynamodb
    implementation("software.amazon.awssdk:dynamodb:2.19.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


application {
    mainClass.set("MainKt")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/aseemsavio/dynamo-kt")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN") // taken from the github-action
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}


