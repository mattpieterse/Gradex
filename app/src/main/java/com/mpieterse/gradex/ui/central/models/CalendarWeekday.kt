package com.mpieterse.gradex.ui.central.models

import com.mpieterse.gradex.core.models.data.Keyed
import java.util.UUID

data class CalendarWeekday(


    override val id: UUID = UUID.randomUUID(),
    

    // --- Attributes


    val number: Int? = null,


    val isCurrentMonth: Boolean = true,


    ) : Keyed {
    companion object {
        private const val TAG = "CalendarWeekday"
    }
}