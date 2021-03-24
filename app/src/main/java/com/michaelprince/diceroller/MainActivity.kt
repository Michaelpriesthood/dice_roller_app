package com.michaelprince.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast


/**
 * This Activity allows the User to roll a dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val roLllButton: Button = findViewById(R.id.button)
        roLllButton.setOnClickListener { rollDice() }

//        Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create new dice object with six sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll image
        val diceImage: ImageView = findViewById(R.id.imageView)

//        Conditions based on the Rolled dice
        val drawableResources = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
//        Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResources)
//        Update the contentDescription for screen Readers
        diceImage.contentDescription = diceRoll.toString()

        //Added a Toast widget: A popup message to show that dice is rolled
        val toast: Toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT)
        toast.show()


    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}