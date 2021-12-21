package com.datechnologies.androidtest.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.datechnologies.androidtest.R

/**
 * Screen that displays the D & A Technologies logo.
 * The icon can be moved around on the screen as well as animated.
 * */

//==============================================================================================
// Class Properties
//==============================================================================================

//==============================================================================================
// Static Class Methods
//==============================================================================================

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
    }
}

// TODO: Make the UI look like it does in the mock-up. Allow for horizontal screen rotation.
// TODO: Add a ripple effect when the buttons are clicked

// TODO: When the fade button is clicked, you must animate the D & A Technologies logo.
// TODO: It should fade from 100% alpha to 0% alpha, and then from 0% alpha to 100% alpha

// TODO: The user should be able to touch and drag the D & A Technologies logo around the screen.

// TODO: Add a bonus to make yourself stick out. Music, color, fireworks, explosions!!!
