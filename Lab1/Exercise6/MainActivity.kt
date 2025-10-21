package com.example.mainactivity

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName: EditText = findViewById(R.id.etName)
        val autoComplete: AutoCompleteTextView = findViewById(R.id.autoComplete)
        val spinner: Spinner = findViewById(R.id.spinner)
        val toggleScanner: ToggleButton = findViewById(R.id.toggleScanner)
        val btnScan: Button = findViewById(R.id.btnScan)
        val imageView: ImageView = findViewById(R.id.imageView)
        val btnGenerateBarcode: Button = findViewById(R.id.btnGenerateBarcode)

        val barcodes = arrayOf(
            R.drawable.barcode1,
            R.drawable.barcode2
        )
        
        val fruits = arrayOf("Apple", "Banana", "Mango", "Orange", "Grapes")
        val fruitAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, fruits)
        autoComplete.setAdapter(fruitAdapter)

        val colors = arrayOf("Red", "Blue", "Green", "Yellow", "Violet")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colors)
        spinner.adapter = spinnerAdapter

        toggleScanner.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Scanner Enabled" else "Scanner Disabled"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        btnScan.setOnClickListener {
            val name = editTextName.text.toString()
            val fruit = autoComplete.text.toString()
            val color = spinner.selectedItem.toString()
            val scannerStatus = if (toggleScanner.isChecked) "Enabled" else "Disabled"

            Toast.makeText(this, "Scanning barcode...", Toast.LENGTH_SHORT).show()
        }

        // 🆕 Generate New Barcode
        btnGenerateBarcode.setOnClickListener {
            val randomBarcode = barcodes[Random.nextInt(barcodes.size)]
            imageView.setImageResource(randomBarcode)
            Toast.makeText(this, "New barcode generated!", Toast.LENGTH_SHORT).show()
        }
    }
}

