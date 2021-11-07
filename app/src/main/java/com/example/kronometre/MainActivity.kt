package com.example.kronometre

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.annotation.RequiresApi
import com.example.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var zamaniDurdur:Long = 0
        binding.startButton.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() + zamaniDurdur
            binding.kronometre.start()
            binding.startButton.visibility = View.GONE
            binding.pauseButton.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }
        binding.pauseButton.setOnClickListener {
            zamaniDurdur=binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.pauseButton.visibility = View.GONE
            binding.startButton.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
        binding.resetButton.setOnClickListener {
            binding.kronometre.base=SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur=0
            binding.pauseButton.visibility = View.GONE
            binding.startButton.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }

    }



}