package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import androidx.room.FtsOptions
import androidx.room.Query
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.models.data.Term
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * DAO class for the [Term] entity.
 */
@Dao
interface TermDao : UpsertDao<Term> {
    companion object {
        const val TAG = "TermDao"
    }


    // --- Queries
    
    
    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM term
        """
    )
    suspend fun streamTb(): Flow<List<Term>>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM term
        """
    )
    suspend fun fetchAll(): List<Term>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM term
            WHERE id = :targetId
            LIMIT 1
        """
    )
    suspend fun fetchOne(targetId: UUID): Term?
}