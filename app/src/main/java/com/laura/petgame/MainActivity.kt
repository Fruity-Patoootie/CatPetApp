package com.laura.petgame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private const val TAG = "PetMidterm"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val nameLabel = findViewById<TextView>(R.id.label_name)
        val name = intent.getStringExtra("name")
        nameLabel.text = name

        // Button declarations
        val btnFeed = findViewById<Button>(R.id.btn_feed)
        val btnPlay = findViewById<Button>(R.id.btn_play)
        val btnPet = findViewById<Button>(R.id.btn_pet)
        val btnVet = findViewById<Button>(R.id.btn_vet)

        // Progress Bar declarations
        val barHunger = findViewById<ProgressBar>(R.id.bar_hunger)
        val barEnergy = findViewById<ProgressBar>(R.id.bar_energy)
        val barHealth = findViewById<ProgressBar>(R.id.bar_health)
        val barHappiness = findViewById<ProgressBar>(R.id.bar_happiness)

        btnFeed.setOnClickListener {
            barHunger.progress -= 5;
            barHealth.progress -= 2;

            Log.d("BUTTON_CLICK", "btnFeed clicked!")

            // very long check statement to check win status
            if (barHunger.progress <= 5 && barHealth.progress >= 90 && barEnergy.progress <= 10 && barHappiness.progress >= 90){
                val intent = Intent(this@MainActivity, WinActivity::class.java)

                intent.putExtra("health", barHealth.progress)
                intent.putExtra("energy", barEnergy.progress)
                intent.putExtra("happiness", barHappiness.progress)
                intent.putExtra("hunger", barHunger.progress)


                intent.putExtra("name", name)
                finish()
                startActivity(intent)
            }
        }
        // Play button click event
        btnPlay.setOnClickListener {
            barHunger.progress += 5;
            barEnergy.progress -= 10;

            Log.d("BUTTON_CLICK", "btnPlay clicked!")

            // very long check statement to check win status
            if (barHunger.progress <= 5 && barHealth.progress >= 90 && barEnergy.progress <= 10 && barHappiness.progress >= 90){
                val intent = Intent(this@MainActivity, WinActivity::class.java)

                intent.putExtra("health", barHealth.progress)
                intent.putExtra("energy", barEnergy.progress)
                intent.putExtra("happiness", barHappiness.progress)
                intent.putExtra("hunger", barHunger.progress)

                intent.putExtra("name", name)
                finish()
                startActivity(intent)
            }
        }

        // Vet button click event
        btnVet.setOnClickListener {
            barHappiness.progress -= 10;
            barHealth.progress += 10;

            Log.d("BUTTON_CLICK", "btnFeed clicked!")

            // very long check statement to check win status
            if (barHunger.progress <= 5 && barHealth.progress >= 90 && barEnergy.progress <= 10 && barHappiness.progress >= 90){
                val intent = Intent(this@MainActivity, WinActivity::class.java)

                intent.putExtra("health", barHealth.progress)
                intent.putExtra("energy", barEnergy.progress)
                intent.putExtra("happiness", barHappiness.progress)
                intent.putExtra("hunger", barHunger.progress)

                intent.putExtra("name", name)
                finish()
                startActivity(intent)
            }
        }

        btnPet.setOnClickListener {
            barHappiness.progress += 10;
            barEnergy.progress += 10;

            Log.d("BUTTON_CLICK", "btnFeed clicked!")

            // very long check statement to check win status
            if (barHunger.progress <= 5 && barHealth.progress >= 90 && barEnergy.progress <= 10 && barHappiness.progress >= 90){
                val intent = Intent(this@MainActivity, WinActivity::class.java)

                intent.putExtra("health", barHealth.progress)
                intent.putExtra("energy", barEnergy.progress)
                intent.putExtra("happiness", barHappiness.progress)
                intent.putExtra("hunger", barHunger.progress)

                intent.putExtra("name", name)
                finish()
                startActivity(intent)
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart → happens when Activity becomes visible")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume -> happens when Activity becomes visible")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause → happens when you press Home or open another Activity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop → happens after Home or when Activity is fully hidden")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart → happens when returning from Recents after Home")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy → happens when Back is pressed or Activity is finishing (not guaranteed)")
    }

}