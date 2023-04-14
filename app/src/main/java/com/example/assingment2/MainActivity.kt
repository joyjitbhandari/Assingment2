package com.example.assingment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.assingment2.databinding.ActivityMainBinding
import com.example.assingment2.model.PersonList
import org.json.JSONObject

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var jsonObject: JSONObject
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val cities = resources.getStringArray(R.array.cities)
        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item_list, cities)
        binding.atLocation.setAdapter(arrayAdapter)
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.saveBtn -> {
                    val person = PersonList(
                    binding.etName.text.toString(),
                    binding.etAddress.text.toString(),
                    binding.etDate.text.toString(),
                    binding.etMobile.text.toString(),
                    binding.atLocation.text.toString(),
                    binding.etDesc.text.toString(),
                    binding.etTestField.text.toString()
                )
                if (person.name.isNotBlank() && person.address.isNotBlank() && person.date.isNotBlank() && person.test.isNotBlank() && person.mobile.isNotBlank()) {
                    jsonObject = JSONObject()
                    jsonObject.put("name", person.name)
                    jsonObject.put("address", person.address)
                    jsonObject.put("date", person.date)
                    jsonObject.put("mobile", person.mobile)
                    jsonObject.put("loc", person.loc)
                    jsonObject.put("desc", person.desc)
                    jsonObject.put("test", person.test)

                    Toast.makeText(
                        this,
                        "All data is converted into json value",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    Toast.makeText(this, "Enter All the above credentials", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            binding.nextBtn -> {
                    val intent = Intent(this, FormTwoActivity::class.java)
//                    intent.putExtra("name",binding.etName.text.toString())
//                    intent.putExtra("mobile",binding.etMobile.text.toString())
//                    intent.putExtra("date",binding.etDate.text.toString())
                    startActivity(intent)
            }
        }
    }
}