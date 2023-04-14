package com.example.assingment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assingment2.databinding.ActivityForm2Binding

class FormTwoActivity : AppCompatActivity() {
    lateinit var binding: ActivityForm2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForm2Binding.inflate(layoutInflater)
        setContentView(binding.root)


//        val name = intent.getStringExtra("name").toString()
//        val mobile = intent.getStringExtra("mobile").toString()
//        val date = intent.getStringExtra("date").toString()
//
//
//        binding.textitem1.text = name
//        binding.textitem2.text = mobile
//        binding.textitem3.text = date
    }
}