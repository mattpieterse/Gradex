package com.mpieterse.gradex.core.converters

import androidx.room.TypeConverter
import com.mpieterse.gradex.core.models.data.AssignmentMode
import com.mpieterse.gradex.core.models.data.AssignmentType
import com.mpieterse.gradex.core.models.data.HumanSex
import com.mpieterse.gradex.core.utils.Clogger

/**
 * Type converter for Enum values.
 *
 * **Note:** The private methods are used to convert any generic Enum into its
 * equivalent string representation. As RoomDB does not support generics and the
 * reified parameter type, each Enum will need its own converter.
 *
 * @property EnumConverter.toKotlinAssignmentType
 * @property EnumConverter.toSimpleAssignmentType
 * @property EnumConverter.toKotlinAssignmentMode
 * @property EnumConverter.toSimpleAssignmentMode
 * @property EnumConverter.toKotlinHumanSex
 * @property EnumConverter.toSimpleHumanSex
 *
 * @see EnumConverter.toKotlinEnum (Helper)
 * @see EnumConverter.toSimpleEnum (Helper)
 * @see TypeConverter
 */
class EnumConverter {
    companion object {
        private const val TAG = "EnumConverter"
    }


// --- Helpers


    private fun <T : Enum<T>> toSimpleEnum(value: T?): String? = value?.name
    private inline fun <reified T : Enum<T>> toKotlinEnum(value: String?): T? = value?.let {
        enumValueOf<T>(it)
    }


// --- Converters (AssignmentType)


    /**
     * Converts a primitive [String] to a complex [AssignmentType].
     *
     * @see [toSimpleAssignmentType]
     * @return [AssignmentType]
     */
    @TypeConverter
    fun toKotlinAssignmentType(value: String?): AssignmentType? {
        Clogger.d(
            TAG, "Converting to Kotlin AssignmentType"
        )

        return toKotlinEnum<AssignmentType>(value)
    }


    /**
     * Converts a complex [AssignmentType] to a primitive [String].
     *
     * @see [toKotlinAssignmentType]
     * @return [String]
     */
    @TypeConverter
    fun toSimpleAssignmentType(value: AssignmentType?): String? {
        Clogger.d(
            TAG, "Converting to Simple AssignmentType"
        )

        return toSimpleEnum(value)
    }


// --- Converters (AssignmentMode)


    /**
     * Converts a primitive [String] to a complex [AssignmentMode].
     *
     * @see [toSimpleAssignmentMode]
     * @return [AssignmentMode]
     */
    @TypeConverter
    fun toKotlinAssignmentMode(value: String?): AssignmentMode? {
        Clogger.d(
            TAG, "Converting to Kotlin AssignmentMode"
        )

        return toKotlinEnum<AssignmentMode>(value)
    }


    /**
     * Converts a complex [AssignmentMode] to a primitive [String].
     *
     * @see [toKotlinAssignmentMode]
     * @return [String]
     */
    @TypeConverter
    fun toSimpleAssignmentMode(value: AssignmentMode?): String? {
        Clogger.d(
            TAG, "Converting to Simple AssignmentMode"
        )

        return toSimpleEnum(value)
    }


// --- Converters (HumanSex)


    /**
     * Converts a primitive [String] to a complex [HumanSex].
     *
     * @see [toSimpleHumanSex]
     * @return [HumanSex]
     */
    @TypeConverter
    fun toKotlinHumanSex(value: String?): HumanSex? {
        Clogger.d(
            TAG, "Converting to Kotlin HumanSex"
        )

        return toKotlinEnum<HumanSex>(value)
    }


    /**
     * Converts a complex [HumanSex] to a primitive [String].
     *
     * @see [toKotlinHumanSex]
     * @return [String]
     */
    @TypeConverter
    fun toSimpleHumanSex(value: HumanSex?): String? {
        Clogger.d(
            TAG, "Converting to Simple HumanSex"
        )

        return toSimpleEnum(value)
    }
}