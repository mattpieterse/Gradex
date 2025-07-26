package com.mpieterse.gradex.core.models.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/**
 * Aggregation of a [Subject] entity with its foreign attributes.
 *
 * **Includes:**
 *
 * - [Subject] <> [entity]
 * - [Teacher] -> [teachers]
 * - [Project] -> [projects]
 * - [Grade] -> [grades]
 *
 * @property AggregatedSubject.entity
 * @property AggregatedSubject.teachers
 * @property AggregatedSubject.projects
 * @property AggregatedSubject.grades
 *
 * @see Embedded
 * @see Relation
 */
data class AggregatedSubject(

    /**
     * The queried [Subject] entity.
     */
    @Embedded
    val entity: Subject,


// --- Foreign Attributes


    /**
     * List of foreign [Teacher] entities.
     */
    @Relation(
        entity = Teacher::class,
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = SubjectTeacher::class,
            parentColumn = "subject_id",
            entityColumn = "teacher_id"
        )
    )
    val teachers: List<AggregatedTeacher>,


    /**
     * List of foreign [Grade] entities.
     */
    @Relation(
        entity = Grade::class,
        parentColumn = "id",
        entityColumn = "subject_id"
    )
    val grades: List<Grade>,


    /**
     * List of foreign [Project] entities.
     */
    @Relation(
        entity = Project::class,
        parentColumn = "id",
        entityColumn = "subject_id"
    )
    val projects: List<Project>,


    /**
     * List of foreign [Lecture] entities.
     */
    @Relation(
        entity = Lecture::class,
        parentColumn = "id",
        entityColumn = "subject_id"
    )
    val lectures: List<Lecture>


) {
    companion object {
        private const val TAG = "AggregatedSubject"
    }
}