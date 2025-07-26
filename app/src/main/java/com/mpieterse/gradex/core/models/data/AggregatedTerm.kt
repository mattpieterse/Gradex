package com.mpieterse.gradex.core.models.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Aggregation of a [Term] entity with its foreign attributes.
 *
 * **Includes:**
 *
 * - [Term] <> [entity]
 * - [Subject] -> [subjects]
 *
 * @property AggregatedTerm.entity
 * @property AggregatedTerm.subjects
 *
 * @see Embedded
 * @see Relation
 */
data class AggregatedTerm(

    /**
     * The queried [Term] entity.
     */
    @Embedded
    val entity: Term,


// --- Foreign Attributes


    /**
     * List of foreign [Subject] entities.
     */
    @Relation(
        entity = Subject::class,
        parentColumn = "id",
        entityColumn = "term_id"
    )
    val subjects: List<AggregatedSubject>


) {
    companion object {
        private const val TAG = "AggregatedTerm"
    }
}