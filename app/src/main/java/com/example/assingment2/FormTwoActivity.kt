package com.example.assingment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assingment2.databinding.ActivityForm2Binding


class FormTwoActivity : AppCompatActivity() {
    lateinit var binding: ActivityForm2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForm2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        val name = intent.getStringExtra("name")
        val mobile = intent.getStringExtra("mobile")
        val date = intent.getStringExtra("date")

        binding.textitem1.text = name
        binding.textitem2.text = mobile
        binding.textitem3.text = date
    }
}