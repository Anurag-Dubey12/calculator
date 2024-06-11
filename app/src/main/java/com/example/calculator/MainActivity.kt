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

        val textResult: TextView = findViewById(R.id.tv_result)

        val buttonIds = listOf(
            R.id.btn_0 to "0", R.id.btn_1 to "1", R.id.btn_2 to "2", R.id.btn_3 to "3",
            R.id.btn_4 to "4", R.id.btn_5 to "5", R.id.btn_6 to "6", R.id.btn_7 to "7",
            R.id.btn_8 to "8", R.id.btn_9 to "9", R.id.btn_add to "+", R.id.btn_subtract to "-",
            R.id.btn_multiply to "*", R.id.btn_divide to "/", R.id.btn_decimal to ".",
            R.id.btn_negative to "-",
            R.id.btn_sin to "sin(", R.id.btn_cos to "cos(", R.id.btn_tan to "tan(",
            R.id.btn_log to "log(", R.id.btn_ln to "ln(", R.id.btn_pi to "3.14159265",
            R.id.btn_sqrt to "sqrt(", R.id.btn_square to "^2",
            R.id.btn_open to "(", R.id.btn_close to ")"
        )

        for ((id, value) in buttonIds) {
            findViewById<Button>(id).setOnClickListener {
                textResult.append(value)
            }
        }

        findViewById<Button>(R.id.btn_clear).setOnClickListener {
            textResult.text = ""
        }

        findViewById<Button>(R.id.btn_equals).setOnClickListener {
            val expression = ExpressionBuilder(textResult.text.toString()).build()
            try {
                val result = expression.evaluate()
                textResult.text = result.toString()
            } catch (e: Exception) {
                textResult.text = "Error"
            }
        }
    }
}