package com.mpieterse.gradex.core.models.data

import com.mpieterse.gradex.core.converters.EnumConverter

/**
 * Enum to define the birth-issued sex of a human.
 *
 * @property HumanSex.UNSET
 * @property HumanSex.F
 * @property HumanSex.M
 *
 * @see EnumConverter
 */
enum class HumanSex {

    /**
     * Default value for when no choice is specified.
     *
     * @see F
     * @see M
     */
    UNSET,

    /**
     * Legally assigned female at birth.
     *
     * @see M
     * @see UNSET
     */
    F,

    /**
     * Legally assigned male at birth.
     *
     * @see F
     * @see UNSET
     */
    M,
}