package com.datechnologies.androidtest.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.datechnologies.androidtest.R

/**
 * The main screen that lets you navigate to all other screens in the app.
 *
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MainActivityTheme)
        setContentView(R.layout.activity_main)

    }

    /**
     * =========================================================================================
     * INSTRUCTIONS
     * =========================================================================================
     *
     * 1. UI must work on Android phones of multiple sizes. Do not worry about Android Tablets.
     *
     * 2. Use this starter project as a base and build upon it. It is ok to remove some of the
     *    provided code if necessary.
     *
     * 3. Read the additional 'TODO' comments throughout the codebase, they will guide you.
     *
     * 3. Please take care of the bug(s) we left for you in the project as well.
     *
     * Thank you and Good luck. -  D & A Technologies
     * =========================================================================================
     */

    // TODO: Make the UI look like it does in the mock-up
    // TODO: Add a ripple effect when the buttons are clicked
    //==============================================================================================
    // Button Click Methods
    //==============================================================================================

}