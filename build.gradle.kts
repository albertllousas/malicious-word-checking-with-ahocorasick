plugins {
    alias(libs.plugins.kotlin.jvm)
    id("me.champeau.jmh") version "0.7.1"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ahocorasick)
    implementation(libs.jmh.core)
    implementation(libs.jmh.generator.annprocess)

    testImplementation(libs.junit.jupiter)
    testImplementation(libs.kotest.assertions)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
