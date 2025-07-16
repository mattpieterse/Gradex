package com.mpieterse.gradex.core.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Upsert
import com.mpieterse.gradex.core.models.data.Auditable
import com.mpieterse.gradex.core.models.data.Keyed

/**
 * Contract to define a [Dao] with simple upsert functionalities.
 *
 * **Note:** This [Dao] requires the entities using it to be subtypes of [Keyed]
 * and [Auditable]. If the entity is not a subtype of both of these contracts, a
 * custom implementation should be used instead.
 */
@Dao
interface UpsertDao<T> where T : Keyed, T : Auditable {
    companion object {
        const val TAG = "UpsertDao"
    }


    // --- Queries


    @Insert(onConflict = OnConflictStrategy.ABORT)
    @Deprecated(
        message = "Use the UPSERT dual-function method instead.",
        replaceWith = ReplaceWith("upsert()"),
        level = DeprecationLevel.WARNING
    )
    suspend fun insert(entity: T)


    @Insert(onConflict = OnConflictStrategy.ABORT)
    @Deprecated(
        message = "Use the UPSERT dual-function method instead.",
        replaceWith = ReplaceWith("upsertAll()"),
        level = DeprecationLevel.WARNING
    )
    suspend fun insertAll(collection: List<T>)


    @Update(onConflict = OnConflictStrategy.ABORT)
    @Deprecated(
        message = "Use the UPSERT dual-function method instead.",
        replaceWith = ReplaceWith("upsert()"),
        level = DeprecationLevel.WARNING
    )
    suspend fun update(entity: T)


    @Update(onConflict = OnConflictStrategy.ABORT)
    @Deprecated(
        message = "Use the UPSERT dual-function method instead.",
        replaceWith = ReplaceWith("upsertAll()"),
        level = DeprecationLevel.WARNING
    )
    suspend fun updateAll(collection: List<T>)


    @Upsert
    suspend fun upsert(entity: T)


    @Upsert
    suspend fun upsertAll(collection: List<T>)


    @Upsert
    suspend fun upsertAll(vararg collection: T)


    @Delete
    suspend fun delete(entity: T)


    @Delete
    suspend fun deleteAll(collection: List<T>)


    @Delete
    suspend fun deleteAll(vararg collection: T)
}