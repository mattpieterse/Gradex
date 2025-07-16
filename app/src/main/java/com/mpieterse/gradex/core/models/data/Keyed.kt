package com.mpieterse.gradex.core.models.data

import androidx.room.PrimaryKey
import com.mpieterse.gradex.core.utils.Clogger
import java.util.UUID

/**
 * Interface definition for an identifiable entity.
 * 
 * @property id
 * @see Keyed.isIdentifierValid
 */
interface Keyed {
    companion object {
        private const val TAG = "Keyed"
    }


    // --- Fields


    /**
     * Unique identifier of the entity.
     *
     * **Note:** This identifier should always be automatically generated from a
     * [UUID]. It has been constructed as a [String] with the purpose of keeping
     * the entity DBaaS independent, but should be treated as a [UUID] in every
     * operation to maintain schema integrity. This property should have a
     * unique constraint.
     *
     * It is advisable to run [isIdentifierValid] before committing to the database.
     *
     * **Implementation:**
     *
     * See additional resources for information regarding annotation usage.
     *
     * ```
     * @PrimaryKey
     * @DocumentId
     * override val id: UUID = UUID.randomUUID()
     * ```
     *
     * @see [PrimaryKey]
     * @see [UUID]
     */
    val id: UUID


    // --- Functions


    /**
     * Checks that the [id] is a valid Version-4 [UUID].
     *
     * **Note:** If the ID is found to be malformed, then the entity should not
     * be committed to the database until it has been fixed to ensure the schema
     * remains uncorrupted. If this check fails, a non-fatal exception will send
     * to crashlytics, whether or not the entity is stored.
     */
    fun isIdentifierValid(): Boolean {
        try {
            return id.version() == 4
        } catch (e: IllegalArgumentException) {
            Clogger.e(
                TAG, "Invalid UUID-ID (Volatile): $id", e
            )

            return false
        }
    }
}