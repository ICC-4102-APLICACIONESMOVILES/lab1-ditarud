package com.example.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var email = findViewById(R.id.email) as EditText
        var password = findViewById(R.id.password) as EditText

        btn_submit.setOnClickListener {
            val email= email.text.toString();
            val password = password.text;
            if (!isEmailValid(email)) {
                Toast.makeText(this, "Formato Incorrecto", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Mail Correcto", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                setResult(RESULT_OK,intent)
                startActivityForResult(intent,1)
            }

        }
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}
