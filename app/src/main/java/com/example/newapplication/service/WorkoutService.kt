package com.example.newapplication.service

import com.example.newapplication.model.DailyActivity

interface WorkoutService {
    suspend fun getWorkout(): List<DailyActivity>
}