package com.example.amaliy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.amaliy.databinding.ActivityMainBinding
import com.example.amaliy.ui.AddFragment
import com.example.amaliy.ui.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var addFragment: AddFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeFragment = HomeFragment()
        addFragment = AddFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.my_container, homeFragment)
            .commit()

        binding.myBottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.my_container, homeFragment)
                        .commit()
                }
                R.id.add -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.my_container, addFragment)
                        .commit()
                }
            }
            true
        }
    }
}