package com.example.worldcup.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcup.R
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ItemMatchBinding

class MatchAdapter (val list: List<Match>): RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
    val view =LayoutInflater.from(parent.context  ).inflate(R.layout.item_match_vertical , parent , false)
    return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentMatch = list[position]
        holder.binding.apply {
            tvTextHomeName.text = currentMatch.homeTeamName
            tvTextAwayName.text = currentMatch.awayTeamName
            tvYear.text = currentMatch.year.toString()
            tvGoalsHomeTeam.text=currentMatch.homeTeamGoals.toString()
            tvGoalseAwayTeam.text=currentMatch.awayTeamGoals.toString()
            tvStadiumName.text = currentMatch.stadium



        }


    }
    override fun getItemCount()=  list.size
    class MatchViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemMatchBinding.bind(viewItem)
    }
}