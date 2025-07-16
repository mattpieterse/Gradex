package com.mpieterse.gradex.core.converters

import androidx.room.TypeConverter
import com.mpieterse.gradex.core.utils.Clogger
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Type converter for date and time values.
 *
 * @property TimeConverter.toKotlinInstant
 * @property TimeConverter.toSimpleInstant
 * @property TimeConverter.toKotlinLocalDate
 * @property TimeConverter.toSimpleLocalDate
 * @property TimeConverter.toKotlinLocalTime
 * @property TimeConverter.toSimpleLocalTime
 * @property TimeConverter.toKotlinLocalDateTime
 * @property TimeConverter.toSimpleLocalDateTime
 *
 * @see TypeConverter
 */
class TimeConverter {
    companion object {
        private const val TAG = "TimeConverter"
    }


// --- Converters (Instant)


    /**
     * Converts a primitive [Long] to a complex [Instant].
     *
     * @see [toSimpleInstant]
     * @return [Instant]
     */
    @TypeConverter
    fun toKotlinInstant(value: Long?): Instant? {
        Clogger.d(
            TAG, "Converting to Kotlin Instant"
        )

        return value?.let {
            Instant.ofEpochMilli(it)
        }
    }


    /**
     * Converts a complex [Instant] to a primitive [Long].
     *
     * @see [toKotlinInstant]
     * @return [Long]
     */
    @TypeConverter
    fun toSimpleInstant(value: Instant?): Long? {
        Clogger.d(
            TAG, "Converting to Simple Instant"
        )

        return value?.toEpochMilli()
    }


// --- Converters (LocalDate)


    /**
     * Converts a primitive [String] to a complex [LocalDate].
     *
     * @see [toSimpleLocalDate]
     * @return [LocalDate]
     */
    @TypeConverter
    fun toKotlinLocalDate(value: String?): LocalDate? {
        Clogger.d(
            TAG, "Converting to Kotlin LocalDate"
        )

        return value?.let {
            LocalDate.parse(it)
        }
    }


    /**
     * Converts a complex [LocalDate] to a primitive [String].
     *
     * @see [toKotlinLocalDate]
     * @return [String]
     */
    @TypeConverter
    fun toSimpleLocalDate(value: LocalDate?): String? {
        Clogger.d(
            TAG, "Converting to Simple LocalDate"
        )

        return value?.toString()
    }


// --- Converters (LocalTime)


    /**
     * Converts a primitive [String] to a complex [LocalTime].
     *
     * @see [toSimpleLocalTime]
     * @return [LocalTime]
     */
    @TypeConverter
    fun toKotlinLocalTime(value: String?): LocalTime? {
        Clogger.d(
            TAG, "Converting to Kotlin LocalTime"
        )

        return value?.let {
            LocalTime.parse(it)
        }
    }


    /**
     * Converts a complex [LocalTime] to a primitive [String].
     *
     * @see [toKotlinLocalTime]
     * @return [String]
     */
    @TypeConverter
    fun toSimpleLocalTime(value: LocalTime?): String? {
        Clogger.d(
            TAG, "Converting to Simple LocalTime"
        )

        return value?.toString()
    }


// --- Converters (LocalDateTime)


    /**
     * Converts a primitive [String] to a complex [LocalDateTime].
     *
     * @see [toSimpleLocalDateTime]
     * @return [LocalDateTime]
     */
    @TypeConverter
    fun toKotlinLocalDateTime(value: String?): LocalDateTime? {
        Clogger.d(
            TAG, "Converting to Kotlin LocalDateTime"
        )

        return value?.let {
            LocalDateTime.parse(it)
        }
    }


    /**
     * Converts a complex [LocalDateTime] to a primitive [String].
     *
     * @see [toKotlinLocalDateTime]
     * @return [String]
     */
    @TypeConverter
    fun toSimpleLocalDateTime(value: LocalDateTime?): String? {
        Clogger.d(
            TAG, "Converting to Simple LocalDateTime"
        )

        return value?.toString()
    }
}