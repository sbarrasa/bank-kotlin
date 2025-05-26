import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

val group = "com.sbarrasa"
val version = "1.0-SNAPSHOT"
val jvmVersion = "1.9.22"
val exposedVersion = "0.50+"
val h2Version = "2.2+"
val ktorVersion = "2.3+"
val logbackVersion = "1.5+"
val dateTimeVersion = "0.5+"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
    implementation("com.h2database:h2:$h2Version")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")
    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-test-host-jvm:2.3.13")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.22")
}


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "19"
}