package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.models.data.Subject

/**
 * DAO class for the [Subject] entity.
 */
@Dao
interface SubjectDao : UpsertDao<Subject> {
    companion object {
        const val TAG = "SubjectDao"
    }


    // --- Queries
}