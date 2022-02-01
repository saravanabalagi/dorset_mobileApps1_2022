package com.saravanabalagi.helloworldapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sum1 = sum(4,5)
        val sum2 = sum(5,6,7)
        Log.i("mainAct", "Sum " + sum1 + " " + sum2)

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val num1Value: Int = Integer.parseInt(num1.text.toString())
            val num2Value: Int = Integer.parseInt(num2.text.toString())
//            mainTextView.text = (sum1 + sum2).toString()

            val sumValue: Int = sum(num1Value, num2Value)
            textView.text = sumValue.toString()
        }

    }

    private fun sum(a: Int, b: Int): Int = a + b
    fun sum(a: Int, b: Int, c: Int): Int = a + b + c
}