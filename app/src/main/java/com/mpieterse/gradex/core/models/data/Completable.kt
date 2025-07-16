package com.mpieterse.gradex.core.models.data

import com.mpieterse.gradex.core.utils.Clogger
import java.time.Instant

/**
 *
 * @property completedAt
 *
 * @see Completable.isCompleted
 * @see Completable.isDiscarded
 * @see Completable.complete
 * @see Completable.reassign
 */
interface Completable {
    companion object {
        private const val TAG = "Completable"
    }


// --- Fields


    /**
     * The [Instant] at which the entity was marked as complete.
     *
     * **Implementation:**
     *
     * ```
     * override var completedAt: Instant? = null
     * ```
     */
    var completedAt: Instant?


// --- Functions


    /**
     *
     *
     * @see complete
     * @see reassign
     */
    fun isCompleted(): Boolean = (completedAt != null)


    /**
     *
     *
     * @see complete
     * @see reassign
     */
    fun isDiscarded(): Boolean = (completedAt == null)


    /**
     *
     */
    fun complete() = when (isCompleted()) {
        true -> completedAt = Instant.now()
        else -> {
            Clogger.w(
                TAG, "You cannot complete an entity that is already completed."
            )

            throw IllegalStateException("Entity is already completed.")
        }
    }


    /**
     *
     */
    fun reassign() = when (isDiscarded()) {
        true -> completedAt = null
        else -> {
            Clogger.w(
                TAG, "You cannot reassign an entity that is already discarded."
            )

            throw IllegalStateException("Entity is already discarded.")
        }
    }
}