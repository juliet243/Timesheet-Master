package com.example.assignmentpart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*
        This class will perform 'user authentication locally. If a user has been signed up,
        they can use their credentials to log in to the app.
        */

        val regEmail = intent.getStringExtra("email") //Receiving email from sign up intent and storing it
        val regPassword = intent.getStringExtra("password") //Receiving email from sign up intent and storing it
        val email = findViewById<EditText>(R.id.edtSignInEmail)
        val password =  findViewById<EditText>(R.id.edtSignInPassword)
        val login = findViewById<Button>(R.id.btnSignIn)

        //After retrieving data from frontend we use if statements to authenticate user.
        login.setOnClickListener{
            if(email.text.toString() == regEmail.toString() && password.text.toString() == regPassword.toString() )
            {
                //If the credential match user will be allowed to continue into the app
                Toast.makeText(applicationContext, "Login successful!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else if(email.text.toString() != regEmail.toString())
            {
                Toast.makeText(applicationContext, "Incorrect Email Or Password", Toast.LENGTH_LONG).show()
            }
        }
        
    }
}
//--------------------------------------ooo000EndOfFile000ooo---------------------------------------