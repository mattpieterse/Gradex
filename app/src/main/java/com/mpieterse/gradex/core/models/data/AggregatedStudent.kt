package com.mpieterse.gradex.core.models.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Aggregation of a [Student] entity with its foreign attributes.
 *
 * **Includes:**
 *
 * - [Student] <> [entity]
 * - [Degree] -> [degrees]
 *
 * @property AggregatedStudent.entity
 * @property AggregatedStudent.degrees
 *
 * @see Embedded
 * @see Relation
 */
data class AggregatedStudent(

    /**
     * The queried [Student] entity.
     */
    @Embedded
    val entity: Student,


// --- Foreign Attributes


    /**
     * List of foreign [Degree] entities.
     */
    @Relation(
        entity = Degree::class,
        parentColumn = "id",
        entityColumn = "student_id"
    )
    val degrees: List<AggregatedDegree>


) {
    companion object {
        private const val TAG = "AggregatedStudent"
    }
}