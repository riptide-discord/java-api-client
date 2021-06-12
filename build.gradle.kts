plugins {
    java
}

group = "pink.zak.client.wavybot"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:16.0.2")
    annotationProcessor("org.jetbrains:annotations:16.0.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}