package com.mpieterse.gradex.ui.central.adapters

import androidx.recyclerview.widget.DiffUtil
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.ui.central.CalendarWeekday

class CalendarDiffCallback : DiffUtil.ItemCallback<CalendarWeekday>() {
    companion object {
        private const val TAG = "CalendarDiffCallback"
        private const val DEV_VERBOSE_LOGGER = false
    }


// --- Functions


    override fun areItemsTheSame(
        oldItem: CalendarWeekday, newItem: CalendarWeekday
    ): Boolean {
        val result = (oldItem.id == newItem.id)
        if (DEV_VERBOSE_LOGGER) Clogger.d(
            TAG,
            "<areItemsTheSame>: oldItem.id=[${oldItem.id}], newItem.id=[${newItem.id}], result=[${result}]"
        )

        return result
    }


    override fun areContentsTheSame(
        oldItem: CalendarWeekday, newItem: CalendarWeekday
    ): Boolean {
        val result = (oldItem == newItem)
        if (DEV_VERBOSE_LOGGER) Clogger.d(
            TAG,
            "<areContentsTheSame>: oldItem.id=[${oldItem.id}], newItem.id=[${newItem.id}], result=[${result}]"
        )

        return result
    }
}