package com.mpieterse.gradex.ui.central.adapters

import androidx.recyclerview.widget.RecyclerView
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ItemCalendarNumberBinding
import com.mpieterse.gradex.ui.central.CalendarWeekday

class CalendarViewHolder(
    private val binding: ItemCalendarNumberBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        private const val TAG = "CalendarViewHolder"
        private const val DEV_VERBOSE_LOGGER = false
    }


// --- Functions


    /**
     * Binds the data to the view.
     */
    fun bind(
        item: CalendarWeekday
    ) {
        if (DEV_VERBOSE_LOGGER) Clogger.d(
            TAG, "<bind>: id=[${item.id}]"
        )

        setupNumberedDay(item)
    }


    /**
     * Sets up the day number based on the calendar day item.
     */
    private fun setupNumberedDay(
        calendarDay: CalendarWeekday
    ) = when (calendarDay.number == null) {
        true -> {
            binding.tvCalendarNumber.text = ""
            binding.tvCalendarNumber.isClickable = false
            binding.tvCalendarNumber.isClickable = false
            binding.tvCalendarNumber.isFocusable = false
        }

        else -> {
            binding.tvCalendarNumber.text = calendarDay.number.toString()
            binding.tvCalendarNumber.isClickable = true
            binding.tvCalendarNumber.isFocusable = true
        }
    }
}