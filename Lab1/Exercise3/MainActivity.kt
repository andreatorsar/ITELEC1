package com.example.mainactivity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val autoComplete: AutoCompleteTextView = findViewById(R.id.autoComplete)
        val fruits = arrayOf("Apple", "Banana", "Mango", "Orange", "Grapes")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, fruits)
        autoComplete.setAdapter(adapter)

        val spinner: Spinner = findViewById(R.id.spinner)
        val colors = arrayOf("Red", "Blue", "Green", "Yellow", "Violet")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colors)
        spinner.adapter = spinnerAdapter
    }
}
