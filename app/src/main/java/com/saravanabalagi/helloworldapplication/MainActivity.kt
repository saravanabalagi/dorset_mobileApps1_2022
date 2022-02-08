package com.saravanabalagi.helloworldapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

const val MAIN_ACT_KEY = "mainAct"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(MAIN_ACT_KEY, "onCreate called")

        val sum1 = sum(4,5)
        val sum2 = sum(5,6,7)
        Log.i(MAIN_ACT_KEY, "Sum " + sum1 + " " + sum2)

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val num1Value: Int = Integer.parseInt(num1.text.toString())
            val num2Value: Int = Integer.parseInt(num2.text.toString())
//            mainTextView.text = (sum1 + sum2).toString()

            val sumValue: Int = sum(num1Value, num2Value)
            textView.text = sumValue.toString()
        }

        new_activity.setOnClickListener {
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra(MAIN_ACT_KEY, textView.text)
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        Log.i(MAIN_ACT_KEY, "onStart called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(MAIN_ACT_KEY, "onPause called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(MAIN_ACT_KEY, "onResume called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(MAIN_ACT_KEY, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MAIN_ACT_KEY, "onDestroy called")
    }

    private fun sum(a: Int, b: Int): Int = a + b
    fun sum(a: Int, b: Int, c: Int): Int = a + b + c
}