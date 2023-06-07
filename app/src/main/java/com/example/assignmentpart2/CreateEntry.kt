package com.example.assignmentpart2

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.assignmentpart2.databinding.ActivityCreateEntryBinding
import kotlin.math.roundToInt

class CreateEntry : AppCompatActivity() {

    private lateinit var binding: ActivityCreateEntryBinding

    private var timerStared = false
    private lateinit var serviceIntent: Intent
    private var time = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnStart.setOnClickListener{ startStopTimer()}
        binding.btnReset.setOnClickListener { resetTimer() }

        serviceIntent = Intent(applicationContext, TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TimerUpdated))

        val saveButton = findViewById<Button>(R.id.btnSave)

        saveButton.setOnClickListener {
            callActivity()
        }

        //Method to Take and Store Image
        //***************************************************************************
        val getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null)
            {
                var bitmap = it.data!!.extras?.get("data") as Bitmap
                binding.camImage.setImageBitmap(bitmap)
            }
        }

        binding.btnCamera.setOnClickListener() {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            getResult.launch(intent)
        }
        //******************************************************************************
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
    //Get and Display information for entry
    private fun callActivity() {
        val edtxtName = findViewById<EditText>(R.id.edtxtCateName)
        val edtxtCat = findViewById<EditText>(R.id.edtxtEntryDate)
        val tvTime = findViewById<TextView>(R.id.tvDispTimer)
        val entryName = edtxtName.text.toString()
        val entryCat = edtxtCat.text.toString()
        val tvTimer = tvTime.text.toString()

        val intent = Intent(this, DisplayEntry::class.java).also {
            it.putExtra("EXTRA_ENTRYNAME", entryName)
            it.putExtra("EXTRA_ENTRYCAT", entryCat)
            it.putExtra("EXTRA_TIME", tvTimer)
            startActivity(it)
        }
    }
    //*************************************************************************************

    //Timer Methods Bellow
    //*************************************************************************
    private fun resetTimer() {
        stopTimer()
        time = 0.0
        binding.tvDispTimer.text = getTimeStringFromDouble(time)
    }

    private fun startStopTimer() {
        if(timerStared)
            stopTimer()
        else
            startTimer()
    }

    private fun startTimer() {
        serviceIntent.putExtra(TimerService.TimeExtra, time)
        startService(serviceIntent )
        binding.btnStart.text = "Stop"
        timerStared = true
    }

    private fun stopTimer() {
        stopService(serviceIntent)
        binding.btnStart.text = "Start"
        timerStared = false
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver()
    {
        override fun onReceive(context: Context, intent: Intent) {
            time = intent.getDoubleExtra(TimerService.TimeExtra, 0.0)
            binding.tvDispTimer.text = getTimeStringFromDouble(time)
        }
    }

    private fun getTimeStringFromDouble(time: Double): String
    {
        val resultInt = time.roundToInt()
        val hours = resultInt % 86400 / 3600
        val minutes = resultInt % 86400 / 3600 / 60
        val seconds = resultInt % 86400 % 3600 % 60

        return makeTimeString(hours, minutes, seconds)
    }

    private fun makeTimeString(hrs: Int,min: Int,sec: Int): String = String.format("%02d:%02d:%02d", hrs, min, sec)

}
//--------------------------------------ooo000EndOfFile000ooo---------------------------------------