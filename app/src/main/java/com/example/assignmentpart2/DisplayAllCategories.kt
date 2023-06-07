package com.example.assignmentpart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.assignmentpart2.databinding.ActivityDisplayAllCategoriesBinding
//import com.example.assignmentpart2.databinding.ActivityDisplayAllProjectsBinding

class DisplayAllCategories : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayAllCategoriesBinding

   // private lateinit var tvEntryName: TextView
    //private lateinit var tvEntryCategory: TextView
   // @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityDisplayAllCategoriesBinding.inflate(layoutInflater)
       setContentView(binding.root)
       /*
       This activity will allow user to display projects created in the create project activity
       Projects will be stored/saved locally in an array and then displayed on the screen
        */

       //var tvEntryName = findViewById<TextView>(R.id.tvDisplayName)
       //var tvEntryCategory = findViewById<TextView>(R.id.tvDisplayCategory)
       var btnTimer = findViewById<Button>(R.id.btnTimer)

       btnTimer.setOnClickListener {
           val intent = Intent(this, DisplayAllCategories::class.java)
           startActivity(intent)
       }

       val entryName = intent.getStringExtra("categoryname")
       val entryCat = intent.getStringExtra("startdate")

       val dispEntryName = findViewById<TextView>(R.id.tvDisplayName).apply {
           text = entryName
       }
       val dispEntryCat = findViewById<TextView>(R.id.tvDisplayCategory).apply {
           text = entryCat
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
}
//--------------------------------------ooo000EndOfFile000ooo---------------------------------------