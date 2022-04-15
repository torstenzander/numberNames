plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
