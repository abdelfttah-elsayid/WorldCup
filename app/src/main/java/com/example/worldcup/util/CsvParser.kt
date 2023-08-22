package com.example.worldcup.util

import com.example.worldcup.data.domain.Match

class CsvParser {
    fun parse(line:String): Match {

        val tokens =line.split(",")
        return Match(
            year = tokens[Constant.ColumnIndex.YEAR].toInt(),
            stadium =  tokens[Constant.ColumnIndex.STADIUM],
            city =  tokens[Constant.ColumnIndex.CITY],
            homeTeamName =  tokens[Constant.ColumnIndex.HOME_TEAM_NAME],
            awayTeamName = tokens[Constant.ColumnIndex.AWAY_TEAM_NAME],
            homeTeamGoals = tokens[Constant.ColumnIndex.HOME_TEAM_GOALS].toInt(),
            awayTeamGoals = tokens[Constant.ColumnIndex.AWAY_TEAM_GOAL].toInt()

        )
    }



}