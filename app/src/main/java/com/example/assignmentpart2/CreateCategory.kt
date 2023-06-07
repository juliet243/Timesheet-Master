package com.example.assignmentpart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.assignmentpart2.databinding.ActivityCreateCategoryBinding

class CreateCategory : AppCompatActivity() {

    private lateinit var binding: ActivityCreateCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_create_project)

        binding = ActivityCreateCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        This activity will allow user to create a project/category that will be displayed to user on
        DisplayAllProjects activity
        Projects will be stored locally in arrays to then be passed on to the display screen
         */

        val saveButton = findViewById<Button>(R.id.btnCreate)

        saveButton.setOnClickListener {
            callActivity()
        }



        //This will account for event clicking of the navigation bar (similar to if statement format)
        binding.bottomNavigationView.setOnItemSelectedListener {item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.create -> {
                    val intent = Intent(this, Create::class.java)
                    startActivity(intent)
                }
                R.id.display -> {
                    val intent = Intent(this, Display::class.java)
                    startActivity(intent)
                }
                R.id.signOut -> {
                    val intent = Intent(this, SignOut::class.java)
                    startActivity(intent)
                }
                else -> {}
            }
            true
        }

    }
    //Get and Display information for entry
    private fun callActivity() {
        val edtxtName = findViewById<EditText>(R.id.edtxtCateName)
        val edtxtCat = findViewById<EditText>(R.id.edtxtEntryDate)

        val nameCat = edtxtName.text.toString()
        val catStrtDate = edtxtCat.text.toString()


        val intent = Intent(this, DisplayAllCategories::class.java).also {
            it.putExtra("categoryname", nameCat)
            it.putExtra("startdate", catStrtDate)

            startActivity(it)
        }
    }
}
//--------------------------------------ooo000EndOfFile000ooo---------------------------------------