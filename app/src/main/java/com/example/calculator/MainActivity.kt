package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textresult:TextView=findViewById(R.id.tv_result)
        var zero=findViewById<Button?>(R.id.btn_0).setOnClickListener {
            textresult.append("0")
        }
        var one=findViewById<Button?>(R.id.btn_1).setOnClickListener {
            textresult.append("1")

        }
        var two=findViewById<Button>(R.id.btn_2).setOnClickListener {
            textresult.append("2")

        }
        var three=findViewById<Button>(R.id.btn_3).setOnClickListener {
            textresult.append("3")

        }
        var four=findViewById<Button>(R.id.btn_4).setOnClickListener {
            textresult.append("4")
        }

        var five=findViewById<Button>(R.id.btn_5).setOnClickListener{
            textresult.append("5")}
        var six=findViewById<Button>(R.id.btn_6).setOnClickListener{
            textresult.append("6")
        }
        var seven=findViewById<Button>(R.id.btn_7).setOnClickListener{
            textresult.append("7")
        }
        var eight=findViewById<Button>(R.id.btn_8).setOnClickListener{
            textresult.append("8")
        }
        var nine=findViewById<Button>(R.id.btn_9).setOnClickListener{
            textresult.append("9")
        }
        var plus=findViewById<Button>(R.id.btn_add).setOnClickListener{
            textresult.append("+")
        }
        var minus=findViewById<Button>(R.id.btn_subtract).setOnClickListener{
            textresult.append("-")
        }
        var div=findViewById<Button>(R.id.btn_divide).setOnClickListener{
            textresult.append("/")
        }
        var clear=findViewById<Button>(R.id.btn_clear).setOnClickListener{
            textresult.text=" "
        }
        var point=findViewById<Button>(R.id.btn_decimal).setOnClickListener{
            textresult.append(".")
        }
        var multiply=findViewById<Button>(R.id.btn_multiply).setOnClickListener{
            textresult.append("*")
        }
        var negative=findViewById<Button>(R.id.btn_negative).setOnClickListener{
            textresult.append("-")
        }
        var equal=findViewById<Button>(R.id.btn_equals).setOnClickListener{
       val expression= ExpressionBuilder(textresult.text.toString()).build()
            try {
                val result= expression.evaluate()
                textresult.text=result.toString()
            }
            catch (e:java.lang.ArithmeticException){
                textresult.text="Error "
            }
        }
    }
}