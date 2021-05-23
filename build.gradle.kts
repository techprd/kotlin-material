plugins {
    kotlin("multiplatform") version "1.4.31"
    `maven-publish`
}

group = "com.techprd.material"
version = "1.4.31"

repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
}

kotlin {
    js(LEGACY) {
        useCommonJs()
        browser {
            webpackTask {
                cssSupport.enabled = true
                devtool = "source-map"
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.3")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }

}
