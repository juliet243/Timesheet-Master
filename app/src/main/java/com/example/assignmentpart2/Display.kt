package com.example.assignmentpart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.assignmentpart2.databinding.ActivityCreateBinding
import com.example.assignmentpart2.databinding.ActivityDisplayBinding

class Display : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_display)

        binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

            var displayCat = findViewById<ImageButton>(R.id.imgBtnDsplyCat)
            var displayEntry = findViewById<ImageButton>(R.id.imgBtnDsplyEntry)

        displayCat.setOnClickListener{
            val intent = Intent(this, DisplayAllCategories::class.java)
            startActivity(intent)
        }

        displayEntry.setOnClickListener{
            val intent = Intent(this, Report::class.java)
            startActivity(intent)
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
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