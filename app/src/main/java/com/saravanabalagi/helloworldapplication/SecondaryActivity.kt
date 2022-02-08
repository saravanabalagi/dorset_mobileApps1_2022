package com.saravanabalagi.helloworldapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_secondary.*

class SecondaryActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val textFromMainActivity: String? = intent.getStringExtra(MAIN_ACT_KEY)
        welcome_text.text = "Second, Msg: " + textFromMainActivity

        welcome_text.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}