plugins {
    kotlin("multiplatform") version "1.7.20"
    application
}

group = "tech.arnav"
version = "0.0.3"

repositories {
    mavenCentral()
}

kotlin {
    linuxX64 {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    mingwX64 {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    macosX64 {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "14"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        binaries.executable()
        nodejs {
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val linuxX64Main by getting
        val linuxX64Test by getting
        val mingwX64Main by getting
        val mingwX64Test by getting
        val macosX64Main by getting
        val macosX64Test by getting
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}

application {
    mainClass.set("MainKt")
}

dependencies {
    commonMainImplementation("com.github.ajalt.clikt:clikt:3.5.0")
}