package com.example.exam_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var container = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val btnSave = binding.btnSave
        val btnOutput = binding.btnOutput

        btnSave.setOnClickListener {
            addAnagramInContainer()
        }

        btnOutput.setOnClickListener {
            binding.tvCount.text = getAnagrams(container).size.toString()
        }

    }

    private fun addAnagramInContainer() {
        var anagram = binding.etAnagrams.text.toString()
        container.add(anagram)

    }



    private fun getAnagrams(listOfAnagrams: MutableList<String>): List<List<String>> {
        val getAnagramsGroup = mutableMapOf<String, MutableList<String>>()

//        group every string of container with alphabet
        listOfAnagrams.forEach {
            val sortedWord = it.toCharArray().sorted().joinToString("")

            if(!getAnagramsGroup.containsKey(sortedWord)) {
                getAnagramsGroup[sortedWord] = mutableListOf(it)
            } else {
                getAnagramsGroup[sortedWord]?.add(it)
            }
        }

        return getAnagramsGroup.values.toList()

    }

}