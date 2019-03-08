package com.ozoneplayer.ozoneplayerapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.google.android.exoplayer2.util.Util

class HomeActivity : AppCompatActivity() {

    private val radioPlayerButton: Button by lazy { findViewById<Button>(R.id.button_radio_player) }
    private val videoPlayerButton: Button by lazy { findViewById<Button>(R.id.button_video_player) }
    private val mainTabsButton: Button by lazy { findViewById<Button>(R.id.button_main_tabs) }
    private val customPlayerButton: Button by lazy { findViewById<Button>(R.id.button_custom_player) }
    private val startServiceButton: Button by lazy { findViewById<Button>(R.id.button_start_service) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        radioPlayerButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, RadioPlayerActivity::class.java)
            startActivity(intent)

        }

        videoPlayerButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, VideoPlayerActivity::class.java)
            startActivity(intent)
        }


        mainTabsButton.setOnClickListener {

            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
        }

        customPlayerButton.setOnClickListener {

           val intent = Intent(this, CustomPlayerActivity::class.java)
           startActivity(intent)
        }

        startServiceButton.setOnClickListener {
            val intent = Intent(this, AudioPlayerService::class.java)
            Util.startForegroundService(this, intent);
        }

    }

}

