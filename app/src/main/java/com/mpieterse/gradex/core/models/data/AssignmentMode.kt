package com.mpieterse.gradex.core.models.data

import com.mpieterse.gradex.core.converters.EnumConverter

/**
 * Enum to define the medium in which an assignment is completed/submitted.
 *
 * @property AssignmentMode.UNSET
 * @property AssignmentMode.DISTANCE
 * @property AssignmentMode.PROXIMAL
 *
 * @see EnumConverter
 * @see Project
 * @see Grade
 */
enum class AssignmentMode {

    /**
     * Default value for when no choice is specified.
     *
     * @see DISTANCE
     * @see PROXIMAL
     */
    UNSET,

    /**
     * For completion/submission digitally.
     *
     * @see PROXIMAL
     * @see UNSET
     */
    DISTANCE,

    /**
     * For completion/submission in-person.
     *
     * @see DISTANCE
     * @see UNSET
     */
    PROXIMAL,
}