package com.example.diceroller

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This is the main activity where we write code in On create method
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * here, a button's object is created with name rollButton
         */
        val rollButton: Button  = findViewById(R.id.button)
        /**
         * Now setting a click Listener which perform action which is in curly brushes when we click on it.
         * Here, rollDice function is called on clink.
         */
        rollButton.setOnClickListener {
            //calling rolling Dice Function
            rollDice()

            //calling sound function when anyone click on the button
            buttonSound()

            //Animating the image while changing it.

        }

        /**
         * Do a dice roll when app starts
         */
        rollDice()

        }





    /**
     * function to add a sound when button clicks.
     */
    private fun buttonSound() {
        val rollingSound:MediaPlayer = MediaPlayer.create(this, R.raw.dicerolling)
        rollingSound.start()

    }



    /**
     * here is the function which named rollDice which will be executed when rollbutton is pressed
     */

        private fun rollDice() {
        //Create new Dice with 6 sides and roll the dice
            val dice = Dice(6)
            val diceRoll = dice.roll()



        // Find the ImageView in the Layout
            val diceImage: ImageView = findViewById(R.id.diceImageView)

        //Animation ImageView on x-axis 360 degree
        diceImage.animate().apply {
                    duration = 300
                    rotationYBy(360f)
                }.start()

        // Determine which drawable resource ID to use based on the dice roll
            val diceFace = when(diceRoll){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(diceFace)
        }
}
class Dice(private val numSide: Int){
    fun roll(): Int{
        return (1..numSide).random()
    }
}