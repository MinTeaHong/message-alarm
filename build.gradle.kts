plugins {
  kotlin("jvm") version "1.9.24"
}

group = "com.salgam"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("com.squareup.okhttp3:okhttp:4.9.2")
  implementation("org.json:json:20210307")
  testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(17)
}