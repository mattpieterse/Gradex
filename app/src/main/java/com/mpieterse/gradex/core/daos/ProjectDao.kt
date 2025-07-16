package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.models.data.Project

/**
 * DAO class for the [Project] entity.
 */
@Dao
interface ProjectDao : UpsertDao<Project> {
    companion object {
        const val TAG = "ProjectDao"
    }


    // --- Queries
}