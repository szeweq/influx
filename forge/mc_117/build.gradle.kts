buildscript {
    repositories {
        maven("https://maven.minecraftforge.net")
        mavenCentral()
    }
    dependencies {
        classpath("net.minecraftforge.gradle", "ForgeGradle", version = "5.1.+") {
            isChanging = true
        }
    }
}
val getMcVersion: Project.() -> String by project

val forge_version = "1.17.1-37.0.72"
val mc_version = "1.17.1"

println("Configuring Forge for MC $mc_version")

subprojects {
    apply(plugin = "net.minecraftforge.gradle")

    configure<net.minecraftforge.gradle.userdev.UserDevExtension> {
        mappings("official", mc_version)
    }

    dependencies {
        "minecraft" ("net.minecraftforge:forge:$forge_version")
    }
}

//val mc_version: String by project
//val forge_version: String by project
////
////minecraft {
////    mappings("official", mc_version)
////
////}
//
//configure<net.minecraftforge.gradle.userdev.UserDevExtension> {
//    mappings("official", mc_version)
//}
//
//dependencies {
//    "minecraft" ("net.minecraftforge:forge:$forge_version")
//}