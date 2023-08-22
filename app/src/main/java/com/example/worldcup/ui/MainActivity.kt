

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
    }

    override fun addCallbacks() {
            binding.apply {
                arrowNext.setOnClickListener{
                 val match =   DataManger.getNextMatch()
                bindMatch(match)
                }
                arrowPrevious.setOnClickListener{
                    val match = DataManger.getPreviousMatch()
                    bindMatch(match)
                }

            }
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
        bindMatch(DataManger.getCurrentMatch())
        }
    private fun bindMatch(match: Match){
        binding?.apply {

            tvYear.text = match.year.toString()
            tvGoalsHomeTeam.text = match.homeTeamGoals.toString()
            tvGoalseAwayTeam.text = match.awayTeamGoals.toString()
            tvStadiumName.text = match.stadium
            tvTextHomeName.text = match.homeTeamName
            tvTextAwayName.text = match.awayTeamName

        }
    }


}
