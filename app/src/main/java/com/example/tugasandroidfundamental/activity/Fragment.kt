package com.example.tugasandroidfundamental.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tugasandroidfundamental.R
import com.example.tugasandroidfundamental.fragment.FirstFragment
import com.example.tugasandroidfundamental.fragment.SecondFragment
import com.google.android.material.button.MaterialButton

class Fragment : AppCompatActivity() {
    private lateinit var firstFragmentButton: MaterialButton
    private lateinit var secondFragmentButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        firstFragmentButton = findViewById<MaterialButton?>(R.id.firstFragmentButton).apply {
            setOnClickListener {
                replaceFragment(firstFragment)
            }
        }
        secondFragmentButton = findViewById<MaterialButton?>(R.id.secondFragmentButton).apply {
            setOnClickListener {
                replaceFragment(secondFragment)
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}