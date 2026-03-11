package com.laura.petgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//import com.bumptech.glide.Glide;
class StartGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val image = findViewById<ImageView>(R.id.img)
        //Glide.with(this).load(R.drawable.rest).into(image)
        val startButton = findViewById<Button>(R.id.btn_start)


        val name = intent.getStringExtra("name")
        startButton.setOnClickListener{
            val editText = findViewById<EditText>(R.id.edit_name)
            val name = editText.text.toString()
            val intent = Intent(this@StartGameActivity, MainActivity::class.java)
            intent.putExtra("name", name)

            startActivity(intent)
        }

    }
}