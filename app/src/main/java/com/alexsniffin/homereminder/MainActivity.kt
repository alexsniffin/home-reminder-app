package com.alexsniffin.homereminder

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging

class MainActivity : AppCompatActivity() {
    val TAG = "HomeReminder"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseInstallations.getInstance().getToken(true)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Installations", "Installation auth token: " + task.result?.token)
                    Toast.makeText(baseContext, task.result?.token, Toast.LENGTH_SHORT).show()
                } else {
                    Log.e("Installations", "Unable to get Installation auth token")
                }
            }

        Firebase.messaging.subscribeToTopic("home-reminder")
            .addOnCompleteListener { task ->
                var msg = "Subscribed"
                if (!task.isSuccessful) {
                    msg = "Subscribe failed"
                }
                Log.d(TAG, msg)
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
            }
    }
}
