import com.google.protobuf.gradle.*

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("com.google.protobuf") version "0.8.19"

    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "com.pet"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("net.devh:grpc-spring-boot-starter:2.13.1.RELEASE")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:3.1.3")

    implementation("com.google.protobuf:protobuf-java:3.6.1")

    implementation(project(":grpc:contract"))
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    main {
        java {
            srcDirs("build/generated/source/proto/main/java", "build/generated/source/proto/main/grpc")
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.6.1"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.15.1"
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc") { }
            }
        }
    }
}