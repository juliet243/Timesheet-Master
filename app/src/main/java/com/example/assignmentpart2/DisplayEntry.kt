package com.example.assignmentpart2

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.assignmentpart2.databinding.ActivityCreateBinding
import com.example.assignmentpart2.databinding.ActivityDisplayEntryBinding
import java.text.SimpleDateFormat
import java.util.*

class DisplayEntry : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayEntryBinding

    private lateinit var btnTimer: Button
    private lateinit var btnCalendar: Button
    private lateinit var tvDisplayDate: TextView
    private lateinit var tvEntryName: TextView
    private lateinit var tvEntryCategory: TextView
    private lateinit var tvDisplayTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDisplayEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnTimer = findViewById(R.id.btnTimer)
        tvDisplayDate = findViewById(R.id.tvDisplayedDate)
        btnCalendar = findViewById(R.id.btnCalender)
        tvEntryName = findViewById(R.id.tvDisplayName)
        tvEntryCategory = findViewById(R.id.tvDisplayCategory)
        tvDisplayTime = findViewById(R.id.tvDisplayTime)

        //Clendar Method
        //******************************************************************************************
        val theCalendar = Calendar.getInstance()

        val date = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            theCalendar.set(Calendar.YEAR, year)
            theCalendar.set(Calendar.MONTH, month)
            theCalendar.set(Calendar.DAY_OF_YEAR, dayOfMonth)
            updateAble(theCalendar)
        }

        btnCalendar.setOnClickListener {
            DatePickerDialog(
                this, date, theCalendar.get(Calendar.YEAR),
                theCalendar.get(Calendar.MONTH), theCalendar.get(Calendar.DAY_OF_YEAR)
            ).show()
        }
        //******************************************************************************************
        //Timer button
        btnTimer.setOnClickListener {
            val intent = Intent(this, CreateEntry::class.java)
            startActivity(intent)
        }
        //******************************************************************************************
        //Display Values
        val entryName = intent.getStringExtra("EXTRA_ENTRYNAME")
        val entryCat = intent.getStringExtra("EXTRA_ENTRYCAT")
        val displayTime = intent.getStringExtra("EXTRA_TIME")

        val dispEntryName = findViewById<TextView>(R.id.tvDisplayName).apply {
            text = entryName
        }
        val dispEntryCat = findViewById<TextView>(R.id.tvDisplayCategory).apply {
            text = entryCat
        }
        val dispTime = findViewById<TextView>(R.id.tvDisplayTime).apply {
            text = displayTime
        }
        //******************************************************************************************

        //If statement to move from one activity after menu nav bar has been clicked
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

    //Calendar
    private fun updateAble(theCalendar: Calendar) {
        val format = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(format, Locale.UK)
        tvDisplayDate.text = sdf.format(theCalendar.time)
    }
}
//--------------------------------------ooo000EndOfFile000ooo---------------------------------------