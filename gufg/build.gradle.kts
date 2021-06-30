plugins {
    java
    kotlin("jvm") version "1.5.20"
}

group = "me.lengrand.gufg"
version = "unspecified"

repositories {
    mavenCentral()
    maven{
        url = uri("https://repo.gradle.org/gradle/libs-releases")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation(gradleApi())
    implementation(project(":model"))
    implementation(project(":plugin"))
    runtimeOnly("org.slf4j:slf4j-simple:1.7.10")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}