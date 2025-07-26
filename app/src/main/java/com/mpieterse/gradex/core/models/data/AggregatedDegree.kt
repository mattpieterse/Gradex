package com.mpieterse.gradex.core.models.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Aggregation of a [Degree] entity with its foreign attributes.
 *
 * **Includes:**
 *
 * - [Degree] <> [entity]
 * - [Term] -> [terms]
 *
 * @property AggregatedDegree.entity
 * @property AggregatedDegree.terms
 *
 * @see Embedded
 * @see Relation
 */
data class AggregatedDegree(

    /**
     * The queried [Degree] entity.
     */
    @Embedded
    val entity: Degree,


// --- Foreign Attributes


    /**
     * List of foreign [Term] entities.
     */
    @Relation(
        parentColumn = "id",
        entity = Term::class,
        entityColumn = "degree_id"
    )
    val terms: List<AggregatedTerm>


) {
    companion object {
        private const val TAG = "AggregatedDegree"
    }
}