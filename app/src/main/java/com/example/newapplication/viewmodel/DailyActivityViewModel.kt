package com.example.newapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newapplication.model.DailyActivity
import kotlinx.coroutines.launch

class DailyActivityViewModel : ViewModel() {

    private val _dailySchedules = MutableLiveData<List<DailyActivity>>()

    val dailySchedules: LiveData<List<DailyActivity>> = _dailySchedules


    fun getDailyActivities(){
        viewModelScope.launch {
            val dailySchedules = listOf(
                DailyActivity("MONDAY", listOf(
                    "30 minutes of cardio (running, cycling, or swimming)",
                    "15 minutes of core exercises (planks, crunches, leg raises)",
                    "15 minutes of stretching and cool down"
                )),
                DailyActivity("TUESDAY", listOf(
                    "20 minutes of upper body weightlifting (bench press, shoulder press, bicep curls)",
                    "20 minutes of bodyweight exercises (push-ups, pull-ups, dips)",
                    "20 minutes of stretching and cool down"
                )),
                DailyActivity("WEDNESDAY", listOf(
                    "60 minutes of yoga, focusing on flexibility and balance"
                )),
                DailyActivity("THURSDAY", listOf(
                    "20 minutes of lower body weightlifting (squats, deadlifts, lunges)",
                    "20 minutes of bodyweight exercises (squats, lunges, calf raises)",
                    "20 minutes of stretching and cool down"
                )),
                DailyActivity("FRIDAY", listOf(
                    "30 minutes of cardio",
                    "15 minutes of core strengthening exercises",
                    "15 minutes of stretching and cool down"
                ))
            )

            _dailySchedules.value = dailySchedules
        }
    }



}