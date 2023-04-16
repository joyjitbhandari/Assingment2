package com.example.assingment2
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assingment2.databinding.ActivityMainBinding
import com.example.assingment2.model.PersonList
import org.json.JSONArray
import org.json.JSONObject
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    val jsonArray = JSONArray()
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //for citi drop down view
        val cities = resources.getStringArray(R.array.cities)
        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item_list, cities)
        binding.atLocation.setAdapter(arrayAdapter)


        // for date picker
        val dateEdt = binding.EdtDate
        dateEdt.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c[Calendar.YEAR]
            val month = c[Calendar.MONTH]
            val day = c[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(
                this@MainActivity,
                { view, year, monthOfYear, dayOfMonth ->
                    dateEdt.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },
                year, month, day
            )
            datePickerDialog.show()
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.saveBtn -> {
                if(count<10) {
                    val person = PersonList(
                        binding.etName.text.toString(),
                        binding.etAddress.text.toString(),
                        binding.EdtDate.text.toString(),
                        binding.etMobile.text.toString(),
                        binding.atLocation.text.toString(),
                        binding.etDesc.text.toString(),
                        binding.etTestField.text.toString()
                    )

                    if (person.name.isNotBlank() && person.address.isNotBlank() && person.date.isNotBlank() && person.test.isNotBlank() && person.mobile.isNotBlank()) {
                        val jsonObject = JSONObject()
                        jsonObject.put("name", person.name)
                        jsonObject.put("add", person.address)
                        jsonObject.put("mob", person.mobile)
                        jsonObject.put("date", person.date)
                        jsonObject.put("loc", person.loc)
                        jsonObject.put("desc", person.desc)
                        jsonObject.put("test", person.test)

                        jsonArray.put(jsonObject)

                        Toast.makeText(
                            this,
                            "All data is converted into json value",
                            Toast.LENGTH_SHORT
                        )
                            .show()

                        Log.d("jsonArray", "${jsonArray.toString()}")
                    } else {
                        Toast.makeText(this, "Enter all the above credentials", Toast.LENGTH_SHORT)
                            .show()
                    }
                    count++
                }else{
                    Toast.makeText(
                        this,
                        "You can't add more than 10 details",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            }

            binding.nextBtn -> {
                if(jsonArray.length()>0) {
                    Log.d("jsonArrayData", "${jsonArray}")
                    val intent = Intent(this, FormTwoActivity::class.java)
                    intent.putExtra("jsonArray", jsonArray.toString())
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Enter all the above credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}