plugins {
    id("java")
    kotlin("jvm") version "2.4.10"
    id("org.jetbrains.intellij.platform") version "2.18.1"
}

group = "com.aspid"
version = "0.2.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        val riderHome = providers.gradleProperty("riderHome").orNull
        if (riderHome == null) {
            rider("2026.3")
        } else {
            local(riderHome)
        }
    }
}

kotlin {
    jvmToolchain(25)
}

tasks.jar {
    from(layout.projectDirectory.file("LICENSE")) {
        into("META-INF")
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "263"
            untilBuild = provider { null }
        }
    }
    pluginVerification {
        ides {
            current()
        }
    }
    instrumentCode = false
    buildSearchableOptions = false
}
