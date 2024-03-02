    // Top-level build file where you can add configuration options common to all sub-projects/modules.
    plugins {
        id("com.android.application") version "8.2.2" apply false
        id("org.jetbrains.kotlin.android") version "1.9.0" apply false

        //KSP
        //id("com.google.devtools.ksp") version "1.9.0-1.0.11" apply false

        //Hilt
        id("com.google.dagger.hilt.android") version "2.50" apply false
        id("com.android.library") version "8.2.2" apply false


    }

