package com.sean.foo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var testButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testButton = findViewById(R.id.testButton)

        testButton.setOnClickListener {
            api()
        }
    }

    private fun api() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://restcountries.com/v3.1/all")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.i("MainActivity", "API response")
                println(response.body?.string())
            }
        })
    }
}