package com.mpieterse.gradex.ui.central.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.FragmentHomeOverviewBinding
import com.mpieterse.gradex.ui.central.viewmodels.HomeOverviewViewModel
import com.mpieterse.gradex.ui.central.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeOverviewFragment : Fragment() {
    companion object {
        private const val TAG = "HomeOverviewFragment"
    }


    private lateinit var binds: FragmentHomeOverviewBinding
    private val activeModel: HomeOverviewViewModel by viewModels()
    private val sharedModel: HomeViewModel by activityViewModels()


// --- Lifecycle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = createBindings(inflater, container)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Clogger.d(
            TAG, "Created a new instance of the fragment"
        )

        sharedModel.screenTitle.value = "Overview"
    }


// --- UI


    private fun createBindings(
        inflater: LayoutInflater, container: ViewGroup?
    ): View {
        binds = FragmentHomeOverviewBinding.inflate(inflater, container, false)
        return binds.root
    }
}