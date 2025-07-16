package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import androidx.room.Query
import com.mpieterse.gradex.core.models.data.TeacherCellContact
import com.mpieterse.gradex.core.models.data.TeacherMailContact
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * DAO class for the [TeacherMailContact] entity.
 */
@Dao
interface TeacherMailContactDao : UpsertDao<TeacherMailContact> {
    companion object {
        const val TAG = "TeacherMailContactDao"
    }


// --- Queries


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher_mail_contact
        """
    )
    fun streamTb(): Flow<List<TeacherMailContact>>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher_mail_contact
        """
    )
    suspend fun fetchAll(): List<TeacherMailContact>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher_mail_contact
            WHERE teacher_id = :teacherId
        """
    )
    suspend fun fetchAllByTeacherId(teacherId: UUID): List<TeacherMailContact>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher_mail_contact
            WHERE id = :targetId
            LIMIT 1
        """
    )
    suspend fun fetchOne(targetId: UUID): TeacherCellContact?
}