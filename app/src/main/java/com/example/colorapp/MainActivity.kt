package com.example.colorapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_create)?.setOnClickListener{

            //Get user input from all the channells

            var RedChannelText = findViewById<TextInputEditText>(
                R.id.red_channel)?.text.toString()

            var GreenChannelText = findViewById<TextInputEditText>(
                R.id.green_channel)?.text.toString()

            var BlueChannelText = findViewById<TextInputEditText>(
                R.id.blue_channel)?.text.toString()

            //Check no field is empty

            if (RedChannelText.isEmpty() or GreenChannelText.isEmpty() or BlueChannelText.isEmpty()){
                Toast.makeText(this,"All values are required! 😒", Toast.LENGTH_LONG).show()
            }
            else{
                // Check if 2 hexadecimal characters have been added and if not add the same hexadecimal color again

                if (RedChannelText.length == 1){
                    RedChannelText = RedChannelText.plus(RedChannelText)
                }
                if (GreenChannelText.length == 1){
                    GreenChannelText = GreenChannelText.plus(GreenChannelText)
                }
                if (BlueChannelText.length == 1){
                    BlueChannelText = BlueChannelText.plus(BlueChannelText)
                }

                val colorToDisplay = RedChannelText.plus(GreenChannelText).plus(BlueChannelText)

                val colorAsInt = Color.parseColor('#'.plus(colorToDisplay))
                    findViewById<Button>(R.id.button_hex_view)?.setBackgroundColor(colorAsInt)
            }
        }

    }
}