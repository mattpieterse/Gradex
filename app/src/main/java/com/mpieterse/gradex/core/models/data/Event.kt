package com.mpieterse.gradex.core.models.data

import java.time.LocalDate
import java.time.LocalTime

/**
 *
 */
interface Event : Keyed, Auditable, Stashable {
    companion object {
        private const val TAG = "Event"
    }


// --- Fields


    /**
     * The user-defined alias for the [Event].
     */
    var name: String


    /**
     * The user-defined description for the [Event].
     */
    var additionalNote: String?


    /**
     * The date that the [Event] is scheduled to take place.
     */
    var dateOfEvent: LocalDate


    /**
     * The time that the [Event] is scheduled to start.
     */
    var timeOfStart: LocalTime?


    /**
     * The time that the [Event] is scheduled to cease.
     *
     * **Note:** The value of this field should be guarded to ensure that it is
     * not before or equal to the [timeOfStart]. This ensures that erroneous
     * calculations are not performed at a later stage.
     */
    var timeOfCease: LocalTime?


// --- Functions


    /**
     * Calculates the duration of the [Event] in minutes.
     *
     * **Note:** If the returned value is negative or zero, it is likely that
     * one or more of the following conditions are true:
     *
     * - The [timeOfStart] is `null`.
     * - The [timeOfCease] is `null`.
     * - The [timeOfCease] is before the [timeOfStart].
     * - The [timeOfCease] is the same as the [timeOfStart].
     * - Both values are `null`.
     *
     * @return The number of minutes between [timeOfStart] and [timeOfCease].
     *         This represents the duration of the event, and can be used to
     *         perform further logic.
     *
     * @see timeOfStart
     * @see timeOfCease
     */
    fun getDurationInMinutes(): Int =
        (timeOfCease?.toSecondOfDay() ?: 0) - (timeOfStart?.toSecondOfDay() ?: 0)


    /**
     * Sets the duration of the [Event] in minutes.
     */
    fun setDurationInMinutes(minutes: Int) {
        timeOfCease = timeOfStart?.plusMinutes(minutes.toLong())
    }
}