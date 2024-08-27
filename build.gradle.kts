plugins {
    kotlin("jvm") version "2.0.10"
}

group = "dev.airdead"
version = "1.0"

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        mavenLocal()
    }
}

kotlin {
    jvmToolchain(17)
}