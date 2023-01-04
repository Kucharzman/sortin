package com.example.sortin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sin
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrNums: MutableList<Int> = mutableListOf()

        findViewById<Button>(R.id.bttRand).setOnClickListener {
            val numAmount = findViewById<EditText>(R.id.edtAmount).text.toString().toInt()
                arrNums.clear()

                for (i in 0..numAmount) {

                    val randed = (0..100).random()
                    arrNums += randed

                findViewById<TextView>(R.id.tvNumbers).text = ""
                    for (element in arrNums) {
                        findViewById<TextView>(R.id.tvNumbers).append(element.toString()+" ")
                    }
            }
        }

    }
}