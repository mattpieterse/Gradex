package com.mpieterse.gradex.ui.central.viewmodels

import androidx.lifecycle.ViewModel
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.ui.central.CalendarWeekday
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeCalendarViewModel @Inject constructor() : ViewModel() {
    companion object {
        private const val TAG = "HomeCalendarFragmentViewModel"
    }


// --- Contracts


    fun loadCalendar(): List<CalendarWeekday> {
        val weekdays = mutableListOf<CalendarWeekday>()
        val calendar = Calendar.getInstance()

        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val firstWeekday = calendar.get(Calendar.DAY_OF_WEEK)
        val startIndexOffset = if (firstWeekday == Calendar.MONDAY) {
            0
        } else {
            firstWeekday - 1
        }

        for (x in 0 until startIndexOffset) {
            weekdays.add(CalendarWeekday(isCurrentMonth = false))
        }

        val currentMonthWeekdays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        for (day in 1..currentMonthWeekdays) {
            weekdays.add(CalendarWeekday(number = day, isCurrentMonth = true))
        }

        Clogger.d(
            TAG, "Calendar size: ${weekdays.size}"
        )

        return weekdays
    }


    fun getMonthString(): String {
        val calendar = Calendar.getInstance()
        val format = SimpleDateFormat("MMMM yyyy", Locale.UK)
        return format.format(calendar.time)
    }
}