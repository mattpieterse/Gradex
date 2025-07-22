package com.mpieterse.gradex.ui.central.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.FragmentHomeGradesBinding
import com.mpieterse.gradex.ui.central.viewmodels.HomeGradesViewModel
import com.mpieterse.gradex.ui.central.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeGradesFragment : Fragment() {
    companion object {
        private const val TAG = "HomeGradesFragment"
    }


    private lateinit var binds: FragmentHomeGradesBinding
    private val activeModel: HomeGradesViewModel by viewModels()
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

        sharedModel.screenTitle.value = "Grades"
    }


// --- UI


    private fun createBindings(
        inflater: LayoutInflater, container: ViewGroup?
    ): View {
        binds = FragmentHomeGradesBinding.inflate(inflater, container, false)
        return binds.root
    }
}