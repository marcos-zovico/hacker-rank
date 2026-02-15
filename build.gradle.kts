plugins {
    id("java")
}

group = "marcos.zovico"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.github.stefanbirkner:system-lambda:1.2.1")
    testImplementation("commons-io:commons-io:2.17.0")
}

tasks.test {
    useJUnitPlatform()
}