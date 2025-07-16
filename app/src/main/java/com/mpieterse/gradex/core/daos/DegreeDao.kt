package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import androidx.room.Query
import com.mpieterse.gradex.core.models.data.Degree
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * DAO class for the [Degree] entity.
 */
@Dao
interface DegreeDao : UpsertDao<Degree> {
    companion object {
        const val TAG = "DegreeDao"
    }


    // --- Queries
    

    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM degree
        """
    )
    fun streamTb(): Flow<List<Degree>>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM degree
        """
    )
    suspend fun fetchAll(): List<Degree>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM degree
            WHERE student_id = :targetId
        """
    )
    suspend fun fetchAllByStudentId(targetId: UUID): List<Degree>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT d.* FROM degree d
            INNER  JOIN student s 
                     ON d.student_id = s.id
            WHERE  s.auth_id = :targetId
        """
    )
    suspend fun fetchAllByStudentAuthId(targetId: String): List<Degree> 

    
    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM degree
            WHERE id = :targetId
            LIMIT 1
        """
    )
    suspend fun fetchOne(targetId: UUID): Degree?
}