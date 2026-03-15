import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

dependencies {
    androidRuntimeClasspath(libs.jetbrains.compose.ui.tooling)
}

kotlin {
    android {
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()

        namespace = "com.mcloo.recipes.shared"

        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = false
        }
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation(libs.coil.compose)
            implementation(libs.coil.ktor)
            implementation(libs.compose.material3.adaptive)
            implementation(libs.jetbrains.compose.components.resources)
            implementation(libs.jetbrains.compose.foundation)
            implementation(libs.jetbrains.compose.material.icons.extended)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.navigation3)
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.jetbrains.compose.ui.test)
            implementation(libs.jetbrains.compose.ui.tooling.preview)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)

        }

        androidMain.dependencies {

            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.google.testparameterinjector)
            implementation(libs.koin.test)
        }

        targets.configureEach {
            val isAndroidTarget = platformType == KotlinPlatformType.androidJvm
            compilations.configureEach {
                compileTaskProvider.configure {
                    compilerOptions {
                        if (isAndroidTarget) {
                            freeCompilerArgs.addAll(
                                "-P",
                                "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation" +
                                    "=com.mcloo.recipes.shared.Parcelize",
                            )
                        }
                    }
                }
            }
        }
    }
}

compose.resources {
    publicResClass = false
    packageOfResClass = "com.mcloo.recipes.shared"
    generateResClass = auto
}

tasks.withType<FormatTask> {
    exclude { it.file.path.contains("build/")}
}

tasks.withType<LintTask> {
    exclude { it.file.path.contains("build/")}
}
