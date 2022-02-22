package com.saravanabalagi.helloworldapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*

const val MAIN_ACT_KEY = "mainAct"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(MAIN_ACT_KEY, "onCreate called")

        val snackBar = Snackbar.make(this, parent_layout, "No internet connection (Not Really!)", Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("Retry", View.OnClickListener {
            Toast.makeText(this, "Retry Button Clicked", Toast.LENGTH_LONG).show()
            snackBar.dismiss()
        })
        snackBar.show()

        tohide_layout.visibility = View.GONE;
        new_activity.visibility = View.VISIBLE;

        val sum1 = sum(4,5)
        val sum2 = sum(5,6,7)
        Log.i(MAIN_ACT_KEY, "Sum " + sum1 + " " + sum2)

        val addButton = findViewById<View>(R.id.addButton)
        addButton.setOnTouchListener { view, motionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                Log.i(MAIN_ACT_KEY, "button pressed")
                addButton.setBackgroundColor(getColor(R.color.red_dark))
            } else if(motionEvent.action == MotionEvent.ACTION_UP) {
                view.performClick()
                addButton.setBackgroundColor(getColor(R.color.red))
                Log.i(MAIN_ACT_KEY, "button press released")
            }
            return@setOnTouchListener true
        }

        addButton.setOnClickListener {
            val num1String = num1.text.toString();
            val num2String = num2.text.toString();
            val num1Value: Int = if(num1String.isNotEmpty()) Integer.parseInt(num1String) else 0
            val num2Value: Int = if(num2String.isNotEmpty()) Integer.parseInt(num2String) else 0
//            mainTextView.text = (sum1 + sum2).toString()

            val sumValue: Int = sum(num1Value, num2Value)
            sumTextView.text = sumValue.toString()
        }

        new_activity.setOnClickListener {
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra(MAIN_ACT_KEY, sumTextView.text)
            startActivity(intent)
        }

        fab.setOnClickListener {
            Toast.makeText(this, "fab called", Toast.LENGTH_LONG).show()

            // Taken from
            // https://www.tutorialkart.com/kotlin-android/android-open-url-in-browser-activity/
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/saravanabalagi")
            startActivity(openURL)
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