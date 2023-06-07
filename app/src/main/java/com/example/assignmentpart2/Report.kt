package com.example.assignmentpart2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.assignmentpart2.databinding.ActivityCreateBinding
import com.example.assignmentpart2.databinding.ActivityReportBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet


class Report : AppCompatActivity() {
    private lateinit var binding: ActivityReportBinding
    lateinit var barChart: BarChart
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntries: ArrayList<BarEntry>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_report)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val days = ArrayList<String>()
        days.add("Monday")
        days.add("Tuesday")
        days.add("Wednesday")
        days.add("Thursday")
        days.add("Friday")

        barChart = findViewById<BarChart>(R.id.idBarChart)

        setBarChart()

        barDataSet = BarDataSet(barEntries, "Total Hours")

        //val dataSets = ArrayList<IBarDataSet>()
        //dataSets.add(barDataSet as IBarDataSet)
        //val Data = BarData(dataSets)


        // on below line we are initializing our bar data
        barData = BarData(barDataSet)


        // on below line we are setting data to our bar chart
        barChart.data = barData

        // on below line we are setting colors for our bar chart text
        barDataSet.valueTextColor = Color.BLACK

        // on below line we are setting color for our bar data set
        barDataSet.setColor(resources.getColor(R.color.gold))

        // on below line we are setting text size
        barDataSet.valueTextSize = 16f

        // on below line we are enabling description as false
        barChart.description.isEnabled = false

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

    private fun setBarChart() {

        barEntries = ArrayList()
        barEntries.add(BarEntry(1f, 1f))
        barEntries.add(BarEntry(2f, 5f))
        barEntries.add(BarEntry(3f, 6f))
        barEntries.add(BarEntry(4f, 2f))
        barEntries.add(BarEntry(5f, 3f))
    }
}
//--------------------------------------ooo000EndOfFile000ooo---------------------------------------