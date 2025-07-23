package com.mpieterse.gradex.ui.setting.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ItemDegreeOptionBinding

class DegreeAdapter : ListAdapter<Degree, DegreeViewHolder>(DegreeDiffCallback()) {
    companion object {
        private const val TAG = "DegreeAdapter"
        private const val DEV_VERBOSE_LOGGER = false
    }


// --- Functions (Contract)


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): DegreeViewHolder {
        Clogger.d(
            TAG, "Constructing the ViewHolder"
        )

        // Construct the binding and return the view holder
        return DegreeViewHolder(
            binding = ItemDegreeOptionBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(
        holder: DegreeViewHolder, position: Int
    ) {
        if (DEV_VERBOSE_LOGGER) Clogger.d(
            TAG, "<onBindViewHolder>: position=[$position]"
        )

        holder.bind(getItem(position))
    }


// --- Functions (Helpers)


    fun update(collection: List<Degree>) {
        Clogger.d(
            TAG, "Updating the source collection"
        )

        submitList(collection)
    }
}