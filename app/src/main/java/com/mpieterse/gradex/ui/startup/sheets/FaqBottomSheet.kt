package com.mpieterse.gradex.ui.startup.sheets

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mpieterse.gradex.core.utils.Clogger
import com.mpieterse.gradex.databinding.ModalBottomSheetFaqBinding
import com.mpieterse.gradex.ui.shared.models.Clickable

class FaqBottomSheet : BottomSheetDialogFragment(), Clickable {
    companion object {
        const val TAG = "FaqBottomSheet"
    }


    private lateinit var binds: ModalBottomSheetFaqBinding


// --- Lifecycle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = createBindings(inflater, container)


    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setupTouchListeners()
    }


// --- Internals


    fun openInternalWebpage(
        context: Context, url: String
    ) {
        val addressUri = url.toUri()
        val webBuilder = CustomTabsIntent.Builder().build()
        webBuilder.launchUrl(
            context, addressUri
        )
    }


// --- Event Handlers


    override fun setupTouchListeners() {
        binds.tvLearnMore.setOnClickListener(this)
    }


    override fun onClick(view: View?) = when (view?.id) {
        binds.tvLearnMore.id -> openInternalWebpage(
            requireContext(),
            "https://mattpieterse.gitbook.io/gradex/security-and-privacy#credentials"
        )

        else -> {
            Clogger.w(
                TAG, "Unhandled on-click for: ${view?.id}"
            )
        }
    }


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