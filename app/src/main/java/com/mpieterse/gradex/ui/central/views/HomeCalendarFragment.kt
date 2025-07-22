package com.mpieterse.gradex.ui.central.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.FragmentHomeCalendarBinding
import com.mpieterse.gradex.ui.central.adapters.CalendarAdapter
import com.mpieterse.gradex.ui.central.viewmodels.HomeCalendarFragmentViewModel
import com.mpieterse.gradex.ui.shared.models.Clickable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeCalendarFragment : Fragment(), Clickable {
    companion object {
        private const val TAG = "HomeCalendarFragment"
    }


    private lateinit var adapter: CalendarAdapter
    private lateinit var binds: FragmentHomeCalendarBinding
    private val model: HomeCalendarFragmentViewModel by viewModels()


// --- Lifecycle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = createBindings(inflater, container)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the fragment"
        )

        setupTouchListeners()
        updateCalendar()
    }


// --- Internals


    private fun updateCalendar() {
        adapter = CalendarAdapter()
        binds.rvCalendar.layoutManager = GridLayoutManager(requireContext(), 7)
        binds.rvCalendar.adapter = adapter
        adapter.update(
            model.loadCalendar()
        )
    }


// --- Event Handlers


    override fun setupTouchListeners() {
        binds.fab.setOnClickListener(this)
    }


    override fun onClick(view: View?) = when (view?.id) {
        binds.fab.id -> { /* TODO */
        }

        else -> {
            Clogger.w(
                TAG, "Unhandled on-click for: ${view?.id}"
            )
        }
    }


// --- UI


    private fun createBindings(
        inflater: LayoutInflater, container: ViewGroup?
    ): View {
        binds = FragmentHomeCalendarBinding.inflate(inflater, container, false)
        return binds.root
    }
}