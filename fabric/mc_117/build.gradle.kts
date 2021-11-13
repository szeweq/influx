plugins {
    id("fabric-loom") version ("0.10-SNAPSHOT") apply false
}

val mc_version = "1.17.1"
val loader_version = "0.12.5"
val fabric_version = "0.42.1+1.17"

println("Configuring Fabric for MC $mc_version")

subprojects {
    apply(plugin = "fabric-loom")

    val loom: net.fabricmc.loom.LoomGradleExtension by project

    dependencies {
        "minecraft" ("com.mojang:minecraft:$mc_version")
        "mappings" (loom.officialMojangMappings())
        "modImplementation" ("net.fabricmc:fabric-loader:$loader_version")
    }
}