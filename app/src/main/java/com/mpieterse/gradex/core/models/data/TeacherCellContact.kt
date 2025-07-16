package com.mpieterse.gradex.core.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.UUID

@Entity(
    tableName = "teacher_cell_contact",
    foreignKeys = [
        ForeignKey(
            entity = Teacher::class,
            parentColumns = ["id"],
            childColumns = ["teacher_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
    indices = [
        Index(value = ["id"], unique = true)
    ]
)
data class TeacherCellContact(

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


    @ColumnInfo(name = "teacher_id")
    var teacherId: UUID,


    @ColumnInfo(name = "value")
    var value: String,


    ) : Keyed, Auditable, Stashable {
    companion object {
        private const val TAG = "TeacherCellContact"
    }
}