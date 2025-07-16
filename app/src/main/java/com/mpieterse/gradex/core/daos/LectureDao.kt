package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import com.mpieterse.gradex.core.models.data.Lecture

/**
 * DAO class for the [Lecture] entity.
 */
@Dao
interface LectureDao : UpsertDao<Lecture> {
    companion object {
        const val TAG = "LectureDao"
    }


// --- Queries
}