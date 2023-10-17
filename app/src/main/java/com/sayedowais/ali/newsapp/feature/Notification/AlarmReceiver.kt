package com.sayedowais.ali.newsapp.feature.Notification

import android.Manifest
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.sayedowais.ali.newsapp.MainActivity
import com.sayedowais.ali.newsapp.R

fun setAlarm(timeInMillis: Long, context: Context) {
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(context, AlarmReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
    alarmManager.setRepeating(
        AlarmManager.RTC,
        timeInMillis,
        AlarmManager.INTERVAL_DAY,
        pendingIntent
    )
}
class AlarmReceiver() : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onReceive(
        context: Context,
        intent: Intent
    ) {
        val CHANNEL_ID = "1"
        val CHANNEL_NAME = "NewsApp"
        val CHANNEL_DESCRIPTION = "We miss you! Come back to read the latest news."

        val nBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(CHANNEL_NAME)
            .setContentText(CHANNEL_DESCRIPTION)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        val nManager = NotificationManagerCompat.from(context)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = CHANNEL_DESCRIPTION
            }
            val nManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nManager.createNotificationChannel(channel)
        }
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                MainActivity(),
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                1
            )
            return
        }
        nManager.notify(1, nBuilder)

        Log.d("Alarm Bell", "Alarm just fired")
    }
}