package com.example.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.EditText
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView




class MainActivity : AppCompatActivity() {

    val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartAnotherActivity.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val email = data!!.getStringExtra("email")
                println(email)
                val password = data.getStringExtra("password")
                val textView: TextView = findViewById(R.id.emailText) as TextView
                textView.setOnClickListener {
                    textView.text = email
                }
            }
        }
    }

}
