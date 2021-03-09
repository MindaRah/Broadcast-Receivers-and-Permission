package com.example.broadcastreceiversandpermission.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.broadcastreceiversandpermission.util.Logger.Companion.logDebug
import com.example.broadcastreceiversandpermission.util.Logger.Companion.logError

class BootUpReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action=="android.intent.BOOT_COMPLETED") {
            logDebug("Boot up completed!")
            Toast.makeText(context, " Boot up completed!", Toast.LENGTH_SHORT).show()
        }
        else logError("Not Boot up completed!")
    }
}