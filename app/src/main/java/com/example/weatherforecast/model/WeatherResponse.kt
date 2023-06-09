package com.example.weatherforecast.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.weatherforecast.converters.AlertsConverter
import com.example.weatherforecast.converters.Converters
import com.example.weatherforecast.converters.DailyConverter
import com.example.weatherforecast.converters.HourlyConverter

@Entity(tableName = "WeatherTable")
data class WeatherResponse(
    @TypeConverters(Converters::class)
    val current: Current,
    @TypeConverters(DailyConverter::class)
    val daily: List<Daily>,
    @TypeConverters(HourlyConverter::class)
    val hourly: List<Hourly>,
    @TypeConverters(AlertsConverter::class)
    val alerts: List<Alert>?,
    @PrimaryKey
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)