package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import androidx.room.Query
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.models.data.TeacherCellContact
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * DAO class for the [TeacherCellContact] entity.
 */
@Dao
interface TeacherCellContactDao : UpsertDao<TeacherCellContact> {
    companion object {
        const val TAG = "TeacherCellContactDao"
    }


    // --- Queries
    

    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher_cell_contact
        """
    )
    fun streamTb(): Flow<List<TeacherCellContact>>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher_cell_contact
        """
    )
    suspend fun fetchAll(): List<TeacherCellContact>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher_cell_contact
            WHERE teacher_id = :teacherId
        """
    )
    suspend fun fetchAllByTeacherId(teacherId: UUID): List<TeacherCellContact>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher_cell_contact
            WHERE id = :targetId
            LIMIT 1
        """
    )
    suspend fun fetchOne(targetId: UUID): TeacherCellContact?
}