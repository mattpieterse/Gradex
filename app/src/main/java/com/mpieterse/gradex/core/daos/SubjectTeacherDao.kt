package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.models.data.SubjectTeacher

/**
 * DAO class for the [SubjectTeacher] entity.
 */
@Dao
interface SubjectTeacherDao {
    companion object {
        const val TAG = "SubjectTeacherDao"
    }


    // --- Queries
}