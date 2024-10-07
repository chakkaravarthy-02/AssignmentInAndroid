package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){

        val boxOneText : TextView = findViewById(R.id.box_one_text)
        val boxTwoText : TextView = findViewById(R.id.box_two_text)
        val boxThreeText : TextView = findViewById(R.id.box_three_text)
        val boxFourText : TextView = findViewById(R.id.box_four_text)
        val boxFiveText : TextView = findViewById(R.id.box_five_text)
        val constraintLayout : View = findViewById(R.id.constraint_layout)
        val redButton : Button = findViewById(R.id.red_button)
        val yellowButton : Button = findViewById(R.id.yellow_button)
        val greenButton : Button = findViewById(R.id.green_button)

        val clickableViews : List<View> =
            listOf(boxOneText,boxTwoText,boxThreeText,
                boxFourText,boxFiveText,constraintLayout,
                redButton,yellowButton,greenButton)

        for(item in clickableViews){
            item.setOnClickListener{makeColored(it)}
        }
    }

    private fun makeColored(view : View){
        val boxThreeText : TextView = findViewById(R.id.box_three_text)
        val boxFourText : TextView = findViewById(R.id.box_four_text)
        val boxFiveText : TextView = findViewById(R.id.box_five_text)

        when(view.id){
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
