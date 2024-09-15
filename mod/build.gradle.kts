plugins {
    id("fabric-loom") version "1.6-SNAPSHOT"

}

repositories {
    maven {
        name = "Fabric"
        url = uri("https://maven.fabricmc.net/")
    }
}

dependencies {
    // Minecraft, Mappings, Fabric Loader
    minecraft("com.mojang:minecraft:1.20.1")
    mappings("net.fabricmc:yarn:1.20.1+build.10:v2")
    modImplementation("net.fabricmc:fabric-loader:0.16.2")

    // Fabric API
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.92.2+1.20.1")

    modImplementation("net.fabricmc:fabric-language-kotlin:1.12.0+kotlin.2.0.10")
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand(mapOf("version" to project.version))
    }
}