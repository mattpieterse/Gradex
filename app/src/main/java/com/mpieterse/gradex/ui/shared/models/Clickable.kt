package com.mpieterse.gradex.ui.shared.models

import android.view.View

/**
 * Interface definition for a view that supports [View.OnClickListener].
 *
 * **Note:** This contract is deliberately left empty. It serves as a union for
 * inheritance to ensure that standardised code style conventions are followed.
 * See usage and [Interactable] for implementation details.
 *
 * **Usage:**
 *
 * *The following example assumes that view binding is enabled.*
 *
 * The `else` condition will only be reached if an element has registered itself
 * for touch events, but its implementation has not yet been accounted for. This
 * should be monitored to ensure that logic errors are avoided when debugging.
 *
 * ```
 * override fun onClick(view: View?) = when (view?.id) {
 *     binding.buttonA.id -> ...
 *     binding.buttonB.id -> ...
 *     else -> {
 *         Clogger.w(
 *             TAG, "Unhandled on-click for: ${view?.id}"
 *         )
 *     }
 * }
 * ```
 */
interface Clickable : Interactable, View.OnClickListener