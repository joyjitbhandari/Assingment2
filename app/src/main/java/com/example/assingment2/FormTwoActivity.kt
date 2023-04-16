package com.example.assingment2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.window.OnBackInvokedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.assingment2.databinding.ActivityForm2Binding
import com.example.assingment2.model.PersonList
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.json.JSONArray
import org.json.JSONObject


class FormTwoActivity : AppCompatActivity() , View.OnClickListener{
    lateinit var binding: ActivityForm2Binding

    lateinit var jsonArray: JSONArray
    var item = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForm2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val jsonData = intent.getStringExtra("jsonArray")
         jsonArray = JSONArray(jsonData)

        val jsonObject = jsonArray.getJSONObject(item)
        Log.d("jsonobject", "${jsonArray}")
        binding.item1Name.text = jsonObject.getString("name")
        binding.item1Add.text = jsonObject.getString("add")
        binding.item1Mob.text = jsonObject.getString("mob")
        binding.item1Date.text = jsonObject.getString("date")
        binding.item1Loc.text = jsonObject.getString("loc")
        binding.item1Desc.text = jsonObject.getString("desc")
        binding.item1Test.text = jsonObject.getString("test")
    }
    override fun onClick(view: View?) {
        when(view){

            binding.backBtn->{
                onBackPressed()
            }
            binding.yesBtn->
            {
                finishAffinity()
            }
            binding.noBtn->{
                onBackPressed()
            }
            binding.paginationRight->{
                item++
                if(item<jsonArray.length()){
                    val jsonObject = jsonArray.getJSONObject(item)
                    binding.item1Name.text = jsonObject.getString("name")
                    binding.item1Add.text = jsonObject.getString("add")
                    binding.item1Mob.text = jsonObject.getString("mob")
                    binding.item1Date.text = jsonObject.getString("date")
                    binding.item1Loc.text = jsonObject.getString("loc")
                    binding.item1Desc.text = jsonObject.getString("desc")
                    binding.item1Test.text = jsonObject.getString("test")
                }else{
                    Toast.makeText(this, "No more data", Toast.LENGTH_SHORT).show()
                    item=jsonArray.length()-1
                }
            }
            binding.paginationLeft->{
                item--
                if(item>=0){
                    val jsonObject = jsonArray.getJSONObject(item)
                    binding.item1Name.text = jsonObject.getString("name")
                    binding.item1Add.text = jsonObject.getString("add")
                    binding.item1Mob.text = jsonObject.getString("mob")
                    binding.item1Date.text = jsonObject.getString("date")
                    binding.item1Loc.text = jsonObject.getString("loc")
                    binding.item1Desc.text = jsonObject.getString("desc")
                    binding.item1Test.text = jsonObject.getString("test")
                }else{
                    Toast.makeText(this, "No more data", Toast.LENGTH_SHORT).show()
                    item = 0
                }
            }
        }
    }
}