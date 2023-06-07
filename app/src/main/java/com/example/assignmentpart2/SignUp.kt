package com.example.assignmentpart2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var userEmail = findViewById<EditText>(R.id.edtSignInEmail)
        var userPassword = findViewById<EditText>(R.id.edtSignInPassword)
        val signUp = findViewById<Button>(R.id.btnSignUp)

        /*
        This class will accept user details submitted in the sign up form. Data will be sent to the sign up sheet
        where user authentication will be performed. After authentication a user is allowed to log in and interact
        with the app.
        */

        //What will execute after a user clicks on sigh up button
        signUp.setOnClickListener{

            val intent = Intent(this, Login::class.java)
            intent.putExtra("email",userEmail.text.toString())
            intent.putExtra("password",userPassword.text.toString())
            startActivity(intent)
        }
    }
}
//--------------------------------------ooo000EndOfFile000ooo---------------------------------------