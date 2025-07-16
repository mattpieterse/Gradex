package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import androidx.room.Query
import com.mpieterse.gradex.core.models.data.Student
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * DAO class for the [Student] entity.
 */
@Dao
interface StudentDao : UpsertDao<Student> {
    companion object {
        const val TAG = "StudentDao"
    }


// --- Queries


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM student
        """
    )
    fun streamTb(): Flow<List<Student>>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM student
        """
    )
    suspend fun fetchAll(): List<Student>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM student
            WHERE id = :targetId
            LIMIT 1
        """
    )
    suspend fun fetchOne(targetId: UUID): Student?


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM student
            WHERE auth_id = :authId
            LIMIT 1
        """
    )
    suspend fun fetchOneByAuthenticationId(authId: String): Student?
}