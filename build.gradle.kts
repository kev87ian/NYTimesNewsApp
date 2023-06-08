// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.kapt).apply(false)
    alias(libs.plugins.dagger.hilt).apply(false)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0" apply false
}
true // Needed to make the Suppress annotation work for the plugins block