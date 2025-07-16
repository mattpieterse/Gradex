package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import com.mpieterse.gradex.core.models.data.Grade

/**
 * DAO class for the [Grade] entity.
 */
@Dao
interface GradeDao : UpsertDao<Grade> {
    companion object {
        const val TAG = "GradeDao"
    }


// --- Queries
}