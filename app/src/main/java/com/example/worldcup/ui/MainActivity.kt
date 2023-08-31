

package com.example.worldcup.ui

import android.view.LayoutInflater
import com.example.worldcup.data.DataManger
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ActivityMainBinding
import com.example.worldcup.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val LOG_TAG: String = "MAIN"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    override fun setup() {
        parseFile()
        val adapter = MatchAdapter(DataManger.matches)
        binding.recyclerMatch.adapter = adapter
    }

    override fun addCallbacks() {

                }
    private fun parseFile() {
        val inputStream = assets.open("worldcup.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()

        // Skip the first line (column headers)
        buffer.readLine()

        buffer.forEachLine {
            val currentMatch = parser.parse(it)
            DataManger.addMatch(currentMatch)


        }
    }
    }



