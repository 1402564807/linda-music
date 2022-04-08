import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    id("org.springframework.boot") version "2.6.6"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.mapstruct:mapstruct-processor:1.4.2.Final")
    implementation("com.github.binarywang:weixin-java-mp:4.2.8.B")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.6")
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    implementation("cn.hutool:hutool-all:5.8.0.M2")
    implementation("com.github.ksuid:ksuid:1.1.0")
    implementation("com.qcloud:cos-sts_api:3.1.0")
    implementation("com.auth0:java-jwt:3.19.1")
    implementation("com.qcloud:cos_api:5.6.71")
    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")
    runtimeOnly("mysql:mysql-connector-java")
    runtimeOnly("org.flywaydb:flyway-core")
    runtimeOnly("com.h2database:h2")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("mysql:mysql-connector-java")
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testCompileOnly("org.mapstruct:mapstruct-processor")
    testCompileOnly("org.mapstruct:mapstruct")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

tasks {
    test {
        useJUnitPlatform()
    }
}
