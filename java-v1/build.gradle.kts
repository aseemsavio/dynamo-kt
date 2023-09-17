plugins {
    `java-library`
    kotlin("jvm") version "1.9.0"
    id("com.google.devtools.ksp") version "1.9.0-1.0.11"
    id("org.jlleitschuh.gradle.ktlint") version "11.5.1"
    id("org.jetbrains.dokka") version "1.9.0"
}

group = "com.aseemsavio.dynamokt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    api(project(":annotations"))
    api(platform("com.amazonaws:aws-java-sdk-bom:1.12.552"))
    api("com.amazonaws:aws-java-sdk-dynamodb")
}

tasks.test {
    useJUnitPlatform()
}
