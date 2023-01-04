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
            val numAmount = findViewById<EditText>(R.id.edtAmount).text.toString().toInt() - 1
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

        findViewById<Button>(R.id.bttSort).setOnClickListener {

            //val arrSorted = quickSort(arrNums.toIntArray(),0,arrNums.size)
            var arrNumsSorted: List<Int> = quicksort(arrNums)

            findViewById<TextView>(R.id.tvNumbers).text = ""
            for (element in arrNumsSorted) {
                findViewById<TextView>(R.id.tvNumbers).append(element.toString()+" ")
            }
        }

    }

    fun quicksort(items: List<Int>): List<Int> {
        // Return if the input list is empty or only has 1 entry, since it's already sorted
        if (items.size <= 1) {
            return items
        }

        // Pick a pivot
        val chosenItem: Int = items[items.size / 2]

        // Partition items in three sets: smaller, equal and greater than chosen item
        val smallerList: MutableList<Int> = mutableListOf()
        val equalList: MutableList<Int> = mutableListOf()
        val greaterList: MutableList<Int> = mutableListOf()
        items.forEach {
            when {
                it < chosenItem -> smallerList.add(it)
                it > chosenItem -> greaterList.add(it)
                else -> equalList.add(it)
            }
        }

        // Combine results and return
        val sortedList: MutableList<Int> = mutableListOf()
        sortedList.addAll(quicksort(smallerList)) // Recursive call
        sortedList.addAll(equalList)
        sortedList.addAll(quicksort(greaterList)) // Recursive call
        return sortedList
    }

}