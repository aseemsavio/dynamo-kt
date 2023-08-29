import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm") version "1.9.0"
    id("com.google.devtools.ksp") version "1.9.0-1.0.11"

}

group = "com.aseemsavio"
version = "1.0-SNAPSHOT"

tasks.named<Jar>("jar") {
    archiveBaseName.set("dynamokt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.11")
    implementation("com.squareup:kotlinpoet:1.14.2")
    implementation("com.squareup:kotlinpoet-ksp:1.14.2")

    /* AWS Stuff */
    api(platform("software.amazon.awssdk:bom:2.20.135"))
    // https://mvnrepository.com/artifact/software.amazon.awssdk/dynamodb
    api("software.amazon.awssdk:dynamodb")

    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
