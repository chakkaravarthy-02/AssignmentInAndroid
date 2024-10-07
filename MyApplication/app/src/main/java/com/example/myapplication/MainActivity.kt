package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#3B5998")))

        val statusButton : Button = findViewById(R.id.button4)
        val photoButton :Button = findViewById(R.id.button5)
        val checkIn : Button = findViewById(R.id.button6)

        statusButton.setBackgroundColor(Color.TRANSPARENT)
        photoButton.setBackgroundColor(Color.TRANSPARENT)
        checkIn.setBackgroundColor(Color.TRANSPARENT)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }
}