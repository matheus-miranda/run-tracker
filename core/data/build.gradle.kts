plugins {
    alias(libs.plugins.runtracker.android.library)
}

android {
    namespace = "com.msmlabs.core.data"
}

dependencies {
    implementation(libs.timber)

    implementation(projects.core.domain)
    implementation(projects.core.database)
}
