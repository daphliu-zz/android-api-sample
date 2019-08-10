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
        private const val API_KEY = "TODO"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://maps.googleapis.com/maps/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val geocodingService = retrofit.create(GeocodingService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addressEditText.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                onEnterKey()
                true
            } else {
                false
            }
        }

    }

    private fun onEnterKey() {
        lifecycleScope.launch {
            val address = addressEditText.text.toString()
            val response = geocodingService.geocode(address, API_KEY)
            if (response.status == "OK") {
                val location = response.results.first().geometry.location
                latLngTextView.text = getString(R.string.located_at, location.lat, location.lng)
            } else {
                latLngTextView.text = response.error_message
            }
        }
    }
}
