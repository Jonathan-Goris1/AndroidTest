package com.datechnologies.androidtest.data.responses

/**
 * A data model that represents a chat log message fetched from the D & A Technologies Web Server.
 */
data class Data(
        val avatar_url: String,
        val message: String,
        val name: String,
        val user_id: String
)