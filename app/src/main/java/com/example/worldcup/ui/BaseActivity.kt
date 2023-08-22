

package com.example.worldcup.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    abstract val LOG_TAG: String
    private var _binding: VB? = null // Use VB instead of ViewBinding
    protected val binding get() = requireNotNull(_binding) // Use getter to avoid null
    abstract val bindingInflater: (LayoutInflater) -> VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(binding.root) // Use binding.root directly

        setup()
        addCallbacks()
    }

    abstract fun setup()
    abstract fun addCallbacks()

    protected fun log(value: Any) {
        Log.v(LOG_TAG, value.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null // Clear binding reference to avoid memory leaks
    }
}
