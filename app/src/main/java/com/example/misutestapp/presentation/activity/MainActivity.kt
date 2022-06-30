package com.example.misutestapp.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.misutestapp.R
import com.example.misutestapp.databinding.ActivityMainBinding
import com.example.misutestapp.presentation.fragment.DoctorsListFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(DoctorsListFragment())
        initView()
    }

    private fun initView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.first->{
                    replaceFragment(DoctorsListFragment())
                }
                R.id.second -> {
                    Toast.makeText(this, "Екран заблоковано", Toast.LENGTH_SHORT).show()

                    return@setOnItemSelectedListener false
                }
            }
            true
        }
        binding.bottomNavigationView.setOnItemReselectedListener {  }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.commit()

    }


}