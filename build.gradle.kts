plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceSets {
        main {
            java.srcDirs("src") // Main code in "src/"
        }
        test {
            java.srcDirs("src") // Tests also in "src/"
        }
    }
}

 
