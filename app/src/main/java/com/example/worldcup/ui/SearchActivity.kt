package com.example.worldcup.ui

import android.view.LayoutInflater
import com.example.worldcup.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity<ActivitySearchBinding>() {
    override val LOG_TAG: String = "SEARCH"
    override val bindingInflater: (LayoutInflater) -> ActivitySearchBinding = ActivitySearchBinding::inflate

    override fun setup() {

    }

    override fun addCallbacks() {
    }


}