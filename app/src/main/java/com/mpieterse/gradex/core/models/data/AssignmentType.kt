package com.mpieterse.gradex.core.models.data

import com.mpieterse.gradex.core.converters.EnumConverter

/**
 * Enum to define the category in which an assignment exists.
 *
 * @property AssignmentType.UNSET
 * @property AssignmentType.MAJOR
 * @property AssignmentType.MINOR
 * @property AssignmentType.ACTIVITY
 *
 * @see EnumConverter
 * @see Project
 * @see Grade
 */
enum class AssignmentType {

    /**
     * Default value for when no choice is specified.
     *
     * @see MAJOR
     * @see MINOR
     * @see ACTIVITY
     */
    UNSET,

    /**
     * For majorly important/weighted assignments.
     *
     * @see MINOR
     * @see ACTIVITY
     * @see UNSET
     */
    MAJOR,

    /**
     * For minorly important/weighted assignments.
     *
     * @see MAJOR
     * @see ACTIVITY
     * @see UNSET
     */
    MINOR,

    /**
     * For smaller tasks and homework assignments.
     *
     * @see MAJOR
     * @see MINOR
     * @see UNSET
     */
    ACTIVITY,
}