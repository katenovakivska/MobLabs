package com.example.mymobapplication1

import android.hardware.camera2.params.MeteringRectangle
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val circle = findViewById<RadioButton>(R.id.circle)
        val rectangle = findViewById<RadioButton>(R.id.rectangle)
        val perimeter = findViewById<CheckBox>(R.id.perimeter)
        val square = findViewById<CheckBox>(R.id.square)
        val text  = findViewById<TextView>(R.id.answer)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            if (perimeter.isChecked && square.isChecked){
                val myToast1 = Toast.makeText(this, "Select only one", Toast.LENGTH_SHORT)
                myToast1.show()
            }
            else if ((perimeter.isChecked || square.isChecked) && (rectangle.isChecked || circle.isChecked)) {
                var result = ""
                result += "Selected measurement: "
                if (perimeter.isChecked && circle.isChecked) {
                    result += "P = 2*Pi*R\n"
                } else if (perimeter.isChecked && rectangle.isChecked) {
                    result += "P = 2*(a + b)\n"
                } else if (square.isChecked && rectangle.isChecked) {
                    result += "S = a*b\n"
                } else if (square.isChecked && circle.isChecked) {
                    result += "S = Pi*R^2\n"
                }
                text.text = result
            }
            else{
                val myToast2 = Toast.makeText(this, "Select more..", Toast.LENGTH_SHORT)
                myToast2.show()
            }
        }

    }
}
