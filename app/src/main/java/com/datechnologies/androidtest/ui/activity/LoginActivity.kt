package com.datechnologies.androidtest.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.datechnologies.androidtest.R

/**
 * A screen that displays a login prompt, allowing the user to login to the D & A Technologies Web Server.
 *
 */


//==============================================================================================
// Static Class Methods
//==============================================================================================


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    // TODO: Make the UI look like it does in the mock-up. Allow for horizontal screen rotation.
    // TODO: Add a ripple effect when the buttons are clicked
    // TODO: Save screen state on screen rotation, inputted username and password should not disappear on screen rotation

    // TODO: Send 'email' and 'password' to http://dev.rapptrlabs.com/Tests/scripts/login.php
    // TODO: as FormUrlEncoded parameters.

    // TODO: When you receive a response from the login endpoint, display an AlertDialog.
    // TODO: The AlertDialog should display the 'code' and 'message' that was returned by the endpoint.
    // TODO: The AlertDialog should also display how long the API call took in milliseconds.
    // TODO: When a login is successful, tapping 'OK' on the AlertDialog should bring us back to the MainActivity

    // TODO: The only valid login credentials are:
    // TODO: email: info@rapptrlabs.com

    // TODO: password: Test123
    // TODO: so please use those to test the login.
}