package com.example.picobotella

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

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

