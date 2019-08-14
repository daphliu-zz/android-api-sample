package com.daphneliu.androidapisample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    companion object {
        private const val API_KEY: String = ""// TODO API key
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://example.com") // TODO base url
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // TODO Geocoding API Service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO set up enter key listener to call onEnterKey()
    }

    private fun onEnterKey() {
        lifecycleScope.launch {
            // TODO “You pressed Enter!”
            // TODO make API call
        }
    }
}
