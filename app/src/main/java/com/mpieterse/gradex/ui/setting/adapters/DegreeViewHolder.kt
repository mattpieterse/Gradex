package com.mpieterse.gradex.ui.setting.adapters

import androidx.recyclerview.widget.RecyclerView
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ItemDegreeOptionBinding

class DegreeViewHolder(
    private val binding: ItemDegreeOptionBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        private const val TAG = "DegreeViewHolder"
        private const val DEV_VERBOSE_LOGGER = false
    }


// --- Functions

    
    /**
     * Binds the data to the view.
     */
    fun bind(
        item: Degree
    ) {
        if (DEV_VERBOSE_LOGGER) Clogger.d(
            TAG, "<bind>: id=[${item.id}]"
        )
        
        binding.tvOptionTitle.text = item.name
        binding.tvOptionOther.text = item.id.toString()
    }
}