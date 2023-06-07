package com.example.assignmentpart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.assignmentpart2.databinding.ActivityMainBinding
import com.example.assignmentpart2.databinding.ActivitySetGoalsBinding

class SetGoals : AppCompatActivity() {

    private lateinit var binding:ActivitySetGoalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // setContentView(R.layout.activity_set_goals)

        binding = ActivitySetGoalsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val btnSubmitGoal = findViewById<Button>(R.id.btnSbmtGoal)
        val rdGrpGoal = findViewById<RadioGroup>(R.id.radioGroup)
        var minGoals = findViewById<EditText>(R.id.edTxtMinHrsGoal)
        var maxGoals = findViewById<EditText>(R.id.edTxtMaxHrsGoal)
        var rbDailyGoal = findViewById<RadioButton>(R.id.rbDailyGoal)
        var rbWeeklyGoal = findViewById<RadioButton>(R.id.rbWeeklyGoal)
        var rbMonthlyGoal = findViewById<RadioButton>(R.id.rbMonthlyGoal)
        var selectedGoalPeriod = ""

        //If statements to counter for selected radio button
        btnSubmitGoal.setOnClickListener{
            rdGrpGoal.setOnCheckedChangeListener { group, checkedID ->
                if(checkedID == R.id.rbDailyGoal)
                selectedGoalPeriod = rbDailyGoal.text.toString()

                if(checkedID == R.id.rbWeeklyGoal)
                selectedGoalPeriod = rbWeeklyGoal.text.toString()

                if(checkedID == R.id.rbMonthlyGoal)
                selectedGoalPeriod = rbMonthlyGoal.text.toString()
            }
            //Storing the entered minimum hours per project into "selectedMinHrGoal" variable
            val selectedMinHrGoal = minGoals.text.toString()
            //Storing the entered maximum hours per project into "selectedMaxHrGoal" variable
            val selectedMaxHrGoal = maxGoals.text.toString()

            Toast.makeText(applicationContext, rbDailyGoal.text.toString()+" selected with minimum hours of"+ selectedMinHrGoal +"Hrs selected & maximum hours of " +selectedMaxHrGoal +"Hrs selected", Toast.LENGTH_LONG).show()
            val intent = Intent(this,   MainActivity::class.java)
            startActivity(intent)
        }

        //This will account for each menu item selected and transport user to selected item
        binding.bottomNavigationView.setOnItemSelectedListener {item ->
            when (item.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.create -> {
                    val intent = Intent(this, SetGoals::class.java)
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