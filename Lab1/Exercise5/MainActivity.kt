package com.example.mainactivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageSwitcher: ImageSwitcher
    private var showingRed = true  // start with red light

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSwitcher = findViewById(R.id.imageSwitcher)
        val buttonSwitch: Button = findViewById(R.id.buttonSwitch)

        imageSwitcher.setFactory(ViewSwitcher.ViewFactory {
            val imageView = ImageView(this)
            imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            imageView
        })

        imageSwitcher.setImageResource(R.drawable.one)

        buttonSwitch.setOnClickListener {
            if (showingRed) {
                imageSwitcher.setImageResource(R.drawable.one)
            } else {
                imageSwitcher.setImageResource(R.drawable.two)
            }
            showingRed = !showingRed
        }
    }
}
