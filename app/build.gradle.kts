plugins {
    java
    jacoco
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.mockito:mockito-core:5.6.0")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}

jacoco {
    toolVersion = "0.8.10" 
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) 

    reports {
        xml.required.set(true) 
        html.required.set(true) 
    }
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport) 

    violationRules {
        rule {
            element = "METHOD"

            limit {
                counter = "BRANCH" 
                value = "COVEREDRATIO" 
                minimum = 1.0.toBigDecimal() 
            }
        }
    }
}

// Fail if not 100%
tasks.check {
    dependsOn(tasks.jacocoTestCoverageVerification)
}
