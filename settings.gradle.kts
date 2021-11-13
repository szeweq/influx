pluginManagement {
    repositories {
        // Fabric
        maven ("https://maven.fabricmc.net/")
        // ForgeGradle
        maven ("https://files.minecraftforge.net/maven/")
        mavenCentral()
        gradlePluginPortal()
    }
}


val mcs = arrayOf(":fabric", ":forge")
val subprojects = arrayOf(":modCore", ":modMachinery", ":modMaterials", ":modEnergy")
val versions = arrayOf(":mc_117")

subprojects.forEach { proj ->
    include(":common$proj")
    mcs.forEach { mc ->
        versions.forEach { ver ->
            include(mc + ver + proj)
        }
    }
}
