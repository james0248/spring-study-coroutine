import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.liquibase.gradle") version "2.1.1"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.scatterlab"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot", "spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")
    implementation("io.projectreactor.kotlin", "reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin", "kotlin-reflect")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-reactor")
    implementation("org.springframework.boot", "spring-boot-starter-security")

    implementation("org.springframework.boot", "spring-boot-starter-data-r2dbc")
    implementation("org.postgresql", "r2dbc-postgresql")
    runtimeOnly("org.postgresql", "postgresql")
    implementation("org.flywaydb", "flyway-core")

    testImplementation("org.springframework.boot", "spring-boot-starter-test")
    testImplementation("io.projectreactor", "reactor-test")

    testImplementation("com.h2database", "h2")
    testImplementation("io.r2dbc", "r2dbc-h2")

    testImplementation("io.kotest", "kotest-runner-junit5", "5.5.5")
    testImplementation("io.kotest", "kotest-assertions-core", "5.5.5")
    testImplementation("io.kotest.extensions", "kotest-extensions-spring")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
