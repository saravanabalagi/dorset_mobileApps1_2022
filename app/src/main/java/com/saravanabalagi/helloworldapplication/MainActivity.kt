package com.saravanabalagi.helloworldapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.w("mainAct", "Activity Created")

        val sum1 = sum(4,5)
        val sum2 = sum(5,6,7)
        Log.i("mainAct", "Sum " + sum1 + " " + sum2)

        val mainTextView = findViewById<TextView>(R.id.textView)
        val num1EditText = findViewById<EditText>(R.id.num1)
        val num2EditText = findViewById<EditText>(R.id.num2)

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val num1: Int = Integer.parseInt(num1EditText.text.toString())
            val num2: Int = Integer.parseInt(num2EditText.text.toString())
//            mainTextView.text = (sum1 + sum2).toString()

            val sumValue: Int = sum(num1, num2)
            mainTextView.text = sumValue.toString()
        }

    }

    private fun sum(a: Int, b: Int): Int = a + b
    fun sum(a: Int, b: Int, c: Int): Int = a + b + c
}