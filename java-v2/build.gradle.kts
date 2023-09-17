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
    api(platform("software.amazon.awssdk:bom:2.20.135"))
    // https://mvnrepository.com/artifact/software.amazon.awssdk/dynamodb
    api("software.amazon.awssdk:dynamodb")
    api(project(":annotations"))
}

tasks.test {
    useJUnitPlatform()
}
