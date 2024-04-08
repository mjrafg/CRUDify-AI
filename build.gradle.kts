plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
    id("org.jetbrains.intellij") version "1.13.3"
}

group = "com.mjr"
version = "0.0.1"

repositories {
    mavenCentral()
}
sourceSets.getByName("main") {
    java.srcDir("src/main/java")
    resources.srcDir("src/main/resources")
}
// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2023.3.2")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}
dependencies {
    // Existing dependencies

    // Retrofit core library
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Check for the latest version

    // Gson converter for Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Use the same version as Retrofit

    // Lombok
    implementation("org.projectlombok:lombok:1.18.22") // Use the latest version available
    annotationProcessor("org.projectlombok:lombok:1.18.22")

    // Required for tests if you're using Lombok annotations in your test classes
    testImplementation("org.projectlombok:lombok:1.18.22")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.22")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.1")

    implementation("org.json:json:20210307")

}
tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("222")
        untilBuild.set("232.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }

    withType<ProcessResources> {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
}
