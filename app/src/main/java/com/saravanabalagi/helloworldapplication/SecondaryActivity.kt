package com.saravanabalagi.helloworldapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
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

        countries_list_view.adapter = ArrayAdapter<String>(this, R.layout.countries_list_template, countriesStrings)
        countries_list_view.setOnItemClickListener { adapterView, view, i, l ->
            val text = view.findViewById<TextView>(R.id.country_text).text
            Toast.makeText(this, "$i $l $text" , Toast.LENGTH_SHORT).show()
        }

    }
}