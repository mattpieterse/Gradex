package com.mpieterse.gradex.core.models.data

import com.mpieterse.gradex.core.utils.Clogger
import java.time.Instant

/**
 * Interface definition for an entity with auditing properties.
 *
 * @property createdAt
 * @property updatedAt
 */
interface Auditable {
    companion object {
        private const val TAG = "Auditable"
    }


    // --- Fields


    /**
     * The [Instant] at which the entity was created.
     *
     * **Implementation:**
     *
     * ```
     * override val createdAt: Instant = Instant.now()
     * ```
     */
    val createdAt: Instant


    /**
     * The [Instant] at which the entity was updated.
     *
     * **Note:** This property will only be updated if manually set or if the
     * [touch] function is called (preferred). This value must be updated before
     * saving the entity to ensure an accurate audit history.
     *
     * **Implementation:**
     *
     * ```
     * override var updatedAt: Instant = Instant.now()
     * ```
     */
    var updatedAt: Instant


    // --- Functions


    /**
     * Informs the entity that it has been updated at the current [Instant].
     */
    fun touch() {
        updatedAt = Instant.now()
        Clogger.d(
            TAG, "Entity updated at $updatedAt milliseconds."
        )
    }
}