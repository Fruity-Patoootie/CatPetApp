package com.laura.petgame

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_win)

        val barHunger = findViewById<ProgressBar>(R.id.bar_hunger)
        val barEnergy = findViewById<ProgressBar>(R.id.bar_energy)
        val barHealth = findViewById<ProgressBar>(R.id.bar_health)
        val barHappiness = findViewById<ProgressBar>(R.id.bar_happiness)

        val hunger = intent.getIntExtra("hunger", 0)
        val energy = intent.getIntExtra("energy", 0)
        val health = intent.getIntExtra("health", 0)
        val happiness = intent.getIntExtra("happiness", 0)

        barHunger.progress = hunger
        barEnergy.progress = energy
        barHealth.progress = health
        barHappiness.progress = happiness
    }
}