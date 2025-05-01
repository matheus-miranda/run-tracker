plugins {
    alias(libs.plugins.runtracker.jvm.library)
    alias(libs.plugins.runtracker.jvm.junit5)
}

dependencies {
    implementation(projects.core.domain)
}
