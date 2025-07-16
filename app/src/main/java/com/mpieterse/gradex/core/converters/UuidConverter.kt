package com.mpieterse.gradex.core.converters

import androidx.room.TypeConverter
import com.mpieterse.gradex.core.utils.Clogger
import java.util.UUID

/**
 * Type converter for [UUID] values.
 *
 * @property UuidConverter.toKotlinUuid
 * @property UuidConverter.toSimpleUuid
 *
 * @see TypeConverter
 */
class UuidConverter {
    companion object {
        private const val TAG = "UuidConverter"
    }


// --- Converters


    /**
     * Converts a primitive [String] to a complex [UUID].
     *
     * **Note:** This converter supports all versions of a 128-bit [UUID] that
     * are natively supported by the Kotlin [UUID] type. If this method needs to
     * be constrained to specific versions, this must be done separately.
     *
     * @see [toSimpleUuid]
     * @see [UUID.version]
     *
     * @throws IllegalArgumentException for an invalid [UUID].
     * @return [UUID]
     */
    @TypeConverter
    fun toKotlinUuid(value: String): UUID {
        Clogger.d(
            TAG, "Converting to Kotlin UUID"
        )

        return UUID.fromString(value)
    }


    /**
     * Converts a complex [UUID] to a primitive [String].
     *
     * @see [toKotlinUuid]
     * @return [String]
     */
    @TypeConverter
    fun toSimpleUuid(value: UUID): String {
        Clogger.d(
            TAG, "Converting to Simple UUID"
        )

        return value.toString()
    }
}