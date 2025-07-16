package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.mpieterse.gradex.core.models.data.AggregatedTeacher
import com.mpieterse.gradex.core.models.data.Teacher
import com.mpieterse.gradex.core.models.data.TeacherCellContact
import com.mpieterse.gradex.core.models.data.TeacherMailContact
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * DAO class for the [Teacher] entity.
 */
@Dao
interface TeacherDao : UpsertDao<Teacher> {
    companion object {
        const val TAG = "TeacherDao"
    }


// --- Queries


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher
        """
    )
    fun streamTb(): Flow<List<Teacher>>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher
        """
    )
    suspend fun fetchAll(): List<Teacher>


    /**
     * TODO ...
     */
    @Query(
        """
            SELECT * FROM teacher
            WHERE id = :targetId
            LIMIT 1
        """
    )
    suspend fun fetchOne(targetId: UUID): Teacher?


    // --- ...

    /**
     * TODO ...
     */
    @Transaction
    @Query(
        """
            SELECT * FROM teacher
            WHERE id = :targetId
            LIMIT 1
        """
    )
    suspend fun fetchOneAggregatedTeacher(targetId: UUID): AggregatedTeacher?


    /**
     * TODO ...
     */
    @Transaction
    suspend fun upsertWithContacts(
        entity: Teacher,
        mailContacts: List<TeacherMailContact>,
        cellContacts: List<TeacherCellContact>,
        mailContactDao: TeacherMailContactDao,
        cellContactDao: TeacherCellContactDao,
    ) {
        upsert(entity)
        mailContactDao.upsertAll(mailContacts)
        cellContactDao.upsertAll(cellContacts)
    }
}