package com.example.broadcastreceiversandpermission.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast
import com.example.broadcastreceiversandpermission.util.Logger.Companion.logDebug
import com.example.broadcastreceiversandpermission.util.Logger.Companion.logError

//Add airplane delegate
class AirPlaneModeReceiver(val airplaneDelegate: AirplaneDelegate): BroadcastReceiver() {
    //Add a listener
    interface AirplaneDelegate {
        fun showButton()
        fun hideButton()
    }

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        if(action == "android.intent.action.AIRPLANE_MODE") {
            logDebug("Airplane Mode Changed.")
            Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show()

            //val on: Boolean = getModeState(context)
            val on: Boolean = getModeState(context)

            val message = if(on) {
                "Airplane mode is on."
            } else {
                "Airplane mode is off."
            }
            logDebug(message)

            //If it's not on
            if(!on) {
                airplaneDelegate.showButton()
            } else {
                airplaneDelegate.hideButton()
            }
        } else {
            logError("Not Airplane mode.")

        }
    }

    private fun getModeState(context: Context): Boolean {
        return Settings.System.getInt(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) !=0
    }
}