package com.mpieterse.gradex.core.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.UUID

@Entity(
    tableName = "student",
    indices = [
        Index(value = ["id"], unique = true),
        Index(value = ["auth_id"], unique = true)
    ]
)
data class Student(

    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: UUID = UUID.randomUUID(),


    @ColumnInfo(name = "created_at")
    override val createdAt: Instant = Instant.now(),


    @ColumnInfo(name = "updated_at")
    override var updatedAt: Instant = Instant.now(),


// --- Attributes


    @ColumnInfo(name = "auth_id")
    var authId: String,


    ) : Keyed, Auditable {
    companion object {
        private const val TAG = "Student"
    }
}