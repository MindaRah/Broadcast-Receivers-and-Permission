package com.example.broadcastreceiversandpermission.util

import android.os.Parcelable
import com.example.broadcastreceiversandpermission.view.Weather
import kotlinx.android.parcel.Parcelize

@Parcelize

data class WeatherCondition(var date: String, var weatherCondition: Weather) : Parcelable