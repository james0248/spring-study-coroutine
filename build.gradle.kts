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

    implementation("org.springframework.boot", "spring-boot-starter-data-r2dbc")
    implementation("com.github.jasync-sql", "jasync-mysql", "2.1.23")

    implementation("org.liquibase", "liquibase-core", "4.17.2")
    liquibaseRuntime("org.liquibase", "liquibase-core", "4.17.2")
    liquibaseRuntime("mysql", "mysql-connector-java", "8.0.30")
    liquibaseRuntime("info.picocli", "picocli", "4.7.0")

    testImplementation("org.springframework.boot", "spring-boot-starter-test")
    testImplementation("io.projectreactor", "reactor-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

liquibase {
    activities.register("main") {
        this.arguments = mapOf(
            "classpath" to "$projectDir/src/main/resources",
            "changeLogFile" to "db/db.changelog-master.yaml",
            "url" to "jdbc:mysql://localhost:3306/ecommerce?characterEncoding=utf8&serverTimezone=UTC",
            "username" to "scatteradmin",
            "password" to "helloluda",
            "driver" to "com.mysql.cj.jdbc.Driver"
        )
    }
    runList = "main"
}
