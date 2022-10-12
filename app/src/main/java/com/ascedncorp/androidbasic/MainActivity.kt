package com.ascedncorp.androidbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ascedncorp.androidbasic.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
}