package com.example.mainactivity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonStandard: Button = findViewById(R.id.buttonStandard)
        val buttonImage: ImageButton = findViewById(R.id.buttonImage)
        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)

        buttonStandard.setOnClickListener {
            Toast.makeText(this, "Scanning barcode...", Toast.LENGTH_SHORT).show()
        }

        buttonImage.setOnClickListener {
            Toast.makeText(this, "Barcode image clicked!", Toast.LENGTH_SHORT).show()
        }

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Scanner is now enabled." else "Scanner disabled."
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
