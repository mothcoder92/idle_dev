plugins {
    java
    application
    id("org.javamodularity.moduleplugin") version "1.8.15"
    id("org.openjfx.javafxplugin") version "0.0.13"
    id("org.beryx.jlink") version "2.25.0"
}

group = "at.ac.hcw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.12.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainModule.set("at.ac.hcw.idledevgame")
    mainClass.set("at.ac.hcw.idledevgame.HelloApplication")

    //Remove warnings concerning deprecated classes as of vs. 22
    applicationDefaultJvmArgs = listOf(
        "--enable-native-access=javafx.graphics",
        "--add-opens=java.base/java.lang=ALL-UNNAMED",
        "--add-opens=java.base/sun.misc=ALL-UNNAMED"
    )
}

javafx {
    version = "22.0.1"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    implementation("org.controlsfx:controlsfx:11.2.1")
    implementation("org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jlink {
    imageZip.set(layout.buildDirectory.file("/distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))

    launcher {
        name = "app"
        jvmArgs = listOf(
            "--enable-native-access=javafx.graphics",
            "--add-opens=java.base/java.lang=ALL-UNNAMED",
            "--add-opens=java.base/sun.misc=ALL-UNNAMED"
        )
    }
}
