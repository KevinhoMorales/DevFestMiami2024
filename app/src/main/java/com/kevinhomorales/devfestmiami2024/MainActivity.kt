package com.kevinhomorales.devfestmiami2024

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kevinhomorales.devfestmiami2024.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView(numberList = getNumbertList())
    }

    private fun getNumbertList(): List<Int> {
        val numeros = (1..1_000_000).toList()
        return numeros
    }

    private fun setUpView(numberList: List<Int>) {

        // USING LOOPS
        val startLoop = System.currentTimeMillis()
        val resultLoops = mutableListOf<Int>()
        for (number in numberList) {
            if (number % 2 == 0) resultLoops.add(number * 2)
        }
        val finishLoop = System.currentTimeMillis()

        // USING HDF
        val startHOF = System.currentTimeMillis()
        val resultHOF = numberList.filter { it % 2 == 0 }.map { it * 2 }
        val finishHOF = System.currentTimeMillis()

        binding.loopsTextId.text = "Loops Time: ${finishLoop - startLoop} ms"
        binding.hofTextId.text = "HOF Time: ${finishHOF - startHOF} ms"
    }
}