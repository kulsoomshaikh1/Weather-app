package com.example.randomguessnumber

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.randomguessnumber.R.id.guessInp
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    private var randomNum = Random.nextInt(1, 1001)
    private lateinit var playerInput : EditText
    private var playerGuess = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerInput = findViewById(guessInp)
    }
    fun showToast() {
        val playerGuessTxt = playerInput.text.toString()
        playerGuess = Integer.parseInt(playerGuessTxt)
        checkGuess(this.playerGuess)

    }
    private fun checkGuess(num: Int) {

        if(randomNum == num) {
            Toast.makeText(this, "Correct, You Win!", Toast.LENGTH_SHORT).show()
        } else if (randomNum > num) {
            Toast.makeText(this, "Nope! The Number is higher.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Nope! The Number is lower.", Toast.LENGTH_SHORT).show()
        }

    }
    fun reset() {
        randomNum = Random.nextInt(1, 1001)
        playerInput.setText("")
    
}
}
