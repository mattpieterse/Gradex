package com.mpieterse.gradex.ui.central.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.FragmentHomeCalendarBinding
import com.mpieterse.gradex.ui.shared.models.Clickable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeCalendarFragment : Fragment(), Clickable {
    companion object {
        private const val TAG = "HomeCalendarFragment"
    }


    private lateinit var binds: FragmentHomeCalendarBinding


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
    }
    
    
// --- Event Handlers


    override fun setupTouchListeners() {
        binds.fab.setOnClickListener(this)
    }


    override fun onClick(view: View?) = when (view?.id) {
        binds.fab.id -> { /* TODO */ }
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