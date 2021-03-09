package com.example.broadcastreceiversandpermission.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast
import com.example.broadcastreceiversandpermission.util.Logger.Companion.logDebug
import com.example.broadcastreceiversandpermission.util.Logger.Companion.logError

class AirPlaneModeReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        if(action=="android.intent.action.AIRPLANE_MODE") {
            logDebug("Airplane Mode Changed.")
            Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show()

            val on: Boolean = getModeState(context)



            } else {
            logError("Not Airplane mode.")

        }
    }

    private fun getModeState(context: Context): Boolean {
        return Settings.System.getInt(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON,
        0) !=0
    }
}