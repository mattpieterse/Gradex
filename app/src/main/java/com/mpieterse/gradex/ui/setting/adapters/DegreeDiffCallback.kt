package com.mpieterse.gradex.ui.setting.adapters

import androidx.recyclerview.widget.DiffUtil
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.utils.Clogger

class DegreeDiffCallback : DiffUtil.ItemCallback<Degree>() {
    companion object {
        private const val TAG = "DegreeDiffCallback"
        private const val DEV_VERBOSE_LOGGER = false
    }


// --- Functions


    override fun areItemsTheSame(
        oldItem: Degree, newItem: Degree
    ): Boolean {
        val result = (oldItem.id == newItem.id)
        if (DEV_VERBOSE_LOGGER) Clogger.d(
            TAG,
            "<areItemsTheSame>: oldItem.id=[${oldItem.id}], newItem.id=[${newItem.id}], result=[${result}]"
        )

        return result
    }


    override fun areContentsTheSame(
        oldItem: Degree, newItem: Degree
    ): Boolean {
        val result = (oldItem == newItem)
        if (DEV_VERBOSE_LOGGER) Clogger.d(
            TAG,
            "<areContentsTheSame>: oldItem.id=[${oldItem.id}], newItem.id=[${newItem.id}], result=[${result}]"
        )

        return result
    }
}