package com.example.weatherforecast.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "AlertsTable")
class AlertModel (
    //sa3a youm no3
    @PrimaryKey
    var id:Int,
    var startDay:String,
    var endDay:String,
    var alertHour:Int,
    var alertType:String
    ):Serializable