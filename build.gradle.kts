import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val exposedVersion = "0.50.1"
val h2Version = "2.3.232"
val kotlinVersion = "2.2.21"
val logbackVersion = "1.5.19"
val ktorVersion = "2.3.11"
val dateTimeVersion = "0.6.2"


plugins {
   kotlin("jvm") version "2.2.21"
   id("io.ktor.plugin") version "2.3.11"
   id("org.jetbrains.kotlin.plugin.serialization") version "2.2.21"
}

group = "com.swelms"
version = "1.0-SNAPSHOT"

repositories {
   mavenCentral()
   maven("https://jitpack.io") {
      metadataSources {
         mavenPom()
         artifact()
      }
   }
}

dependencies {
   implementation("io.ktor:ktor-server-core:$ktorVersion")
   implementation("io.ktor:ktor-server-netty:$ktorVersion")
   implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
   implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
   implementation("io.ktor:ktor-server-status-pages:$ktorVersion")
   implementation("io.ktor:ktor-server-openapi:$ktorVersion")
   implementation("io.ktor:ktor-server-swagger:$ktorVersion")
   implementation("io.ktor:ktor-server-call-logging:${ktorVersion}")

   implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:1.7.3")

   implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
   implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
   implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
   implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")

   implementation("com.h2database:h2:$h2Version")
   implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")
   implementation("ch.qos.logback:logback-classic:$logbackVersion")
   implementation("com.github.sbarrasa:swelms-lib:82f2006f74")

   testImplementation(kotlin("test"))
   testImplementation("io.ktor:ktor-server-test-host-jvm:${ktorVersion}")
   testImplementation("io.ktor:ktor-server-tests:$ktorVersion")

}

kotlin {
   compilerOptions {
   }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.compilerOptions {
   freeCompilerArgs.set(listOf("-Xcontext-parameters"))
}