package io.loita.networkchanges

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.loita.networkchanges.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityLiveData: ConnectivityLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        connectivityLiveData = ConnectivityLiveData(application)

        connectivityLiveData.observe(this, Observer { isAvailable ->
            when (isAvailable) {

                true -> binding.networkchanges.text = "Connected with Internet"
                false -> {
                    binding.networkchanges.text = "No network"
                }

            }
        })


    }


}