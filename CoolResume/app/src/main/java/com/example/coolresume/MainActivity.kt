package com.example.coolresume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var workHistory = findViewById<Button>(R.id.workHistoryButton)

        workHistory.setOnClickListener{
            println("Hey you hit the button")

            var moveToWorkHistory = Intent(getApplicationContext(), WorkHistoryActivity :: class.java)
            startActivity(moveToWorkHistory)
        }

            var callButton = findViewById<Button>(R.id.callButton)

            callButton.setOnClickListener{
                println("Call")

                var phoneUri = Uri.parse( "tel: 180097447218")


                var callIntent = Intent(Intent.ACTION_DIAL, phoneUri)
                startActivity(callIntent)

        }

        var emailButton = findViewById<Button>(R.id.emailButton)

        emailButton.setOnClickListener{
            println("Call")




            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("plain/text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "hireCharan@gmail.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, " Nice Resume")
            emailIntent.putExtra(Intent.EXTRA_TEXT, " what an awesome Resume")
            startActivity(emailIntent)

        }

    }

}