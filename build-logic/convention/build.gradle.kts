plugins {
    `kotlin-dsl`
}

group = "com.msmlabs.runtracker.build-logic"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp.gradle.plugin)
    compileOnly(libs.room.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "runtracker.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "runtracker.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

    }
}
