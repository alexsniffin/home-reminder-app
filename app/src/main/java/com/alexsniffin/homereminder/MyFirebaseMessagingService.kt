package com.alexsniffin.homereminder

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {
    val TAG = "HomeReminder"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.from)
        Log.d(TAG, "Notification Message Body: " + (remoteMessage.notification?.body))
        Log.d(TAG, "Notification Message Data: " + (remoteMessage.data.toString()))
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
    }
}