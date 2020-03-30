package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.util.Log
import com.example.android.eggtimernotifications.util.sendNotification
import com.example.android.eggtimernotifications.util.systemService
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d(TAG, "Message data payload: ${message.data}")

        message.notification?.let { notification ->
            Log.d(TAG, "Message Notification Body: ${notification.body}")
            sendNotification(notification.body!!)
        }
    }

    private fun sendNotification(body: String) {
        val manager = applicationContext.systemService<NotificationManager>()
        manager.sendNotification(body, applicationContext)
    }

    private fun sendRegistrationToServer(token: String) {

    }

    companion object {

        private const val TAG = "MyFirebaseMsgService"

    }

}