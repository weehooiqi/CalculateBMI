package com.example.calculatebmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        calculate.setOnClickListener(){
        try{
            val weight: Double = weight.text.toString().toDouble()
            val height: Double = HeightNum.text.toString().toDouble()
            val bmi: Double = calculateBMI(weight, height)

            //todo : display image and things
//            if(bmi<18.50){
//                imgResult.setImageResource(R.drawable.under)
//            }
//            else if(bmi<=24.90 && bmi>=18.50){
//                imgResult.setImageResource(R.drawable.normal)
//            }
//            else if(bmi>=25){
//                imgResult.setImageResource(R.drawable.over)
//            }
//            else{
//                imgResult.setImageResource(R.drawable.empty)
//            }
            val status: String
            when {
                bmi < 18.5 -> {
                    imgResult.setImageResource(R.drawable.under)
                    status = "under"
                }
                bmi < 24.9 -> {
                    imgResult.setImageResource(R.drawable.normal)
                    status = "Normal"
                }
                else -> {
                    imgResult.setImageResource(R.drawable.over)
                    status = "Over"
                }
            }
            bmiResult.text = "BMI %.2f (%s)".format(bmi, status)
        }catch (ex:Exception){
            val toast:Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
        }

        reset.setOnClickListener(){
                imgResult.setImageResource(R.drawable.empty)
                bmiResult.text=""
                HeightNum.text.clear()
                weight.text.clear()

        }

    }
    fun calculateBMI(weight:Double, height:Double):Double{
        //todo:: function to calculate and return BMI
        return weight / Math.pow(height,2.0)
    }

}
