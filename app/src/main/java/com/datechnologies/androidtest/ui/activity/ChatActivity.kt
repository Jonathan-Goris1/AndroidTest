package com.datechnologies.androidtest.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.datechnologies.androidtest.R

/**
 * Screen that displays a list of chats from a chat log.
 */

class ChatActivity : AppCompatActivity() {

    //==============================================================================================
    // Class Properties
    //==============================================================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // TODO: Make the UI look like it does in the mock-up. Allow for horizontal screen rotation.

        // TODO: Retrieve the chat data from http://dev.rapptrlabs.com/Tests/scripts/chat_log.php
        // TODO: Parse this chat data from JSON into ChatLogMessageModel and display it.

    }
}