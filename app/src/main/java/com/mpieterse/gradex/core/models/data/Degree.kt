package com.mpieterse.gradex.core.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.UUID

@Entity(
    tableName = "degree",
    foreignKeys = [
        ForeignKey(
            entity = Student::class,
            parentColumns = ["id"],
            childColumns = ["student_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
    indices = [
        Index(value = ["id"], unique = true),
        Index(value = ["student_id"])
    ]
)
data class Degree(

    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: UUID = UUID.randomUUID(),


    @ColumnInfo(name = "created_at")
    override val createdAt: Instant = Instant.now(),


    @ColumnInfo(name = "updated_at")
    override var updatedAt: Instant = Instant.now(),


    @ColumnInfo(name = "stashed_at")
    override var stashedAt: Instant? = null,


// --- Attributes


    @ColumnInfo(name = "student_id")
    var studentId: UUID,


    @ColumnInfo(name = "name")
    var name: String,


    ) : Keyed, Auditable, Stashable {
    companion object {
        private const val TAG = "Degree"
    }
}