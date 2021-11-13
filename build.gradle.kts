allprojects {
    group = "szeweq.influx"


    beforeEvaluate {
        if (":mc_117" in name) {
            println("Setting MC version for $name")
            setProperty("mc_version", "1.17.1")
            ext["mc_version"] = "1.17.1"
        }
    }
}

project.ext {
    fun Project.mcVersion() = when {
        ":mc_117" in name -> "1.17.1"
        else -> ""
    }
    set("getMcVersion", ::mcVersion)
}

println("Java: " + System.getProperty("java.version") + " JVM: " + System.getProperty("java.vm.version") + " (" + System.getProperty("java.vendor") + ") Arch: " + System.getProperty("os.arch"))