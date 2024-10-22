package com.example.picobotella

import android.media.Image
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val ReviewButton = findViewById<ImageButton>(R.id.icon_star)
        ReviewButton.setOnClickListener {
            val url = "https://play.google.com/store/apps/details?id=com.nequi.MobileApp&hl=es_CO&pli=1"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            startActivity(intent)
        }

        val instructionsButton = findViewById<ImageButton>(R.id.icon_instructions)
        instructionsButton.setOnClickListener{
            val intent = Intent(this, InstructionsActivity::class.java)
            startActivity(intent)
        }

        val pressMeButton: ImageButton = findViewById(R.id.btnPressMe)
        val blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink)
        pressMeButton.startAnimation(blinkAnimation)

        // Ocultar la ActionBar predeterminada
        supportActionBar?.hide()

        // Contador regresivo
        val timerText: TextView = findViewById(R.id.timerText)
        val countDown = object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerText.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                timerText.text = "0"
            }
        }
        countDown.start()
    }
}

