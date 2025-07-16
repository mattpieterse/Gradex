package com.mpieterse.gradex.core.models.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Aggregation of a [Teacher] entity with its foreign attributes.
 *
 * **Includes:**
 *
 * - [Teacher] <> [entity]
 * - [TeacherMailContact] -> [mailContacts]
 * - [TeacherCellContact] -> [cellContacts]
 *
 * @property AggregatedTeacher.entity
 * @property AggregatedTeacher.mailContacts
 * @property AggregatedTeacher.cellContacts
 *
 * @see Embedded
 * @see Relation
 */
data class AggregatedTeacher(

    /**
     * The queried [Teacher] entity.
     */
    @Embedded
    val entity: Teacher,


    // --- Foreign Attributes


    /**
     * List of foreign [TeacherMailContact] entities.
     */
    @Relation(
        parentColumn = "id",
        entityColumn = "teacherId"
    )
    val mailContacts: List<TeacherMailContact>,


    /**
     * List of foreign [TeacherCellContact] entities.
     */
    @Relation(
        parentColumn = "id",
        entityColumn = "teacherId"
    )
    val cellContacts: List<TeacherCellContact>,


    ) {
    companion object {
        private const val TAG = "AggregatedTeacher"
    }
}