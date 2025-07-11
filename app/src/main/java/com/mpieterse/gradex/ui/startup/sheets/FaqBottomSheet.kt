package com.mpieterse.gradex.ui.startup.sheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mpieterse.gradex.databinding.ModalBottomSheetFaqBinding

class FaqBottomSheet : BottomSheetDialogFragment() {
    companion object {
        const val TAG = "FaqBottomSheet"
    }


    private lateinit var binds: ModalBottomSheetFaqBinding


    // --- LifeCycle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = createBindings(inflater, container)


    // --- UI


    /**
     * Construct the view binding for this fragment.
     *
     * @return the root [View] of this fragment within the same context as every
     *         other invocation of the binding instance. This is crucial because
     *         otherwise they would exist in different contexts.
     */
    private fun createBindings(
        inflater: LayoutInflater, container: ViewGroup?
    ): View {
        binds = ModalBottomSheetFaqBinding.inflate(inflater, container, false)
        return binds.root
    }
}