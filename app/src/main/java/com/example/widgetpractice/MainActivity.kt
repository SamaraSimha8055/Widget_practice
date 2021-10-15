package com.example.widgetpractice

import android.R.layout.simple_spinner_item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar = findViewById<SeekBar>(R.id.age_seek_bar)
        val ageTextView = findViewById<TextView>(R.id.age_text_view)
        val spinner = findViewById<Spinner>(R.id.spinner)

        ageTextView.text = String.format(resources.getString(R.string.str_age), 0)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                ageTextView.text = String.format(resources.getString(R.string.str_age), progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        ArrayAdapter.createFromResource(this, R.array.list_of_units,
            simple_spinner_item).also { arrayAdapter ->  spinner.adapter = arrayAdapter}
    }

}