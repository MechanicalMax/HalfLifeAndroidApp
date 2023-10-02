package com.example.halflifecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val massResult: TextView = findViewById(R.id.massResult)
        val originalMassInput: EditText = findViewById(R.id.originalMassInput)
        val passedNumber: EditText = findViewById(R.id.passedNumber)
        val calcButton: Button = findViewById(R.id.calcButton)

        calcButton.setOnClickListener {
            try {
                val oMass = originalMassInput.text.toString().toDouble()
                val lives = passedNumber.text.toString().toDouble()
                val mass = oMass * 0.5.pow(lives)
                massResult.text = mass.toString()
            } catch (ne: NumberFormatException) {
                Toast.makeText(
                    applicationContext,
                    "Please enter numbers in each input", Toast.LENGTH_LONG
                ).show()
                massResult.text = ""
            }
        }
    }
}