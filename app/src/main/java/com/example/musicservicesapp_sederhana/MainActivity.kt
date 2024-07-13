package com.example.musicservicesapp_sederhana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnPlayPause: Button
    private lateinit var btnStop: Button
    private var isPlaying = false
    private lateinit var musicServiceIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlayPause = findViewById(R.id.btnPlayPause)
        btnStop = findViewById(R.id.btnStop)

        musicServiceIntent = Intent(this, MusicService::class.java)

        btnPlayPause.setOnClickListener {
            if (isPlaying) {
                stopService(musicServiceIntent)
                btnPlayPause.text = "Play"
            } else {
                startService(musicServiceIntent)
                btnPlayPause.text = "Pause"
            }
            isPlaying = !isPlaying
        }

        btnStop.setOnClickListener {
            stopService(musicServiceIntent)
            btnPlayPause.text = "Play"
            isPlaying = false
        }
    }
}