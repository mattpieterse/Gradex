package com.mpieterse.gradex.ui.central.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ItemCalendarNumberBinding
import com.mpieterse.gradex.ui.central.models.CalendarWeekday

class CalendarAdapter : ListAdapter<CalendarWeekday, CalendarViewHolder>(CalendarDiffCallback()) {
    companion object {
        private const val TAG = "CalendarAdapter"
        private const val DEV_VERBOSE_LOGGER = false
    }


// --- Functions (Contract)


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CalendarViewHolder {
        Clogger.d(
            TAG, "Constructing the ViewHolder"
        )

        // Construct the binding and return the view holder
        return CalendarViewHolder(
            binding = ItemCalendarNumberBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(
        holder: CalendarViewHolder, position: Int
    ) {
        if (DEV_VERBOSE_LOGGER) Clogger.d(
            TAG, "<onBindViewHolder>: position=[$position]"
        )

        holder.bind(getItem(position))
    }


// --- Functions (Helpers)


    fun update(collection: List<CalendarWeekday>) {
        Clogger.d(
            TAG, "Updating the source collection"
        )

        submitList(collection)
    }
}