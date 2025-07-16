package com.mpieterse.gradex.core.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.UUID

@Entity(
    tableName = "subject_teacher",
    primaryKeys = [
        "subject_id",
        "teacher_id",
    ],
    foreignKeys = [
        ForeignKey(
            entity = Subject::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = Teacher::class,
            parentColumns = ["id"],
            childColumns = ["teacher_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["subject_id"]),
        Index(value = ["teacher_id"])
    ]
)
class SubjectTeacher(

    @ColumnInfo(name = "created_at")
    override val createdAt: Instant = Instant.now(),


    @ColumnInfo(name = "updated_at")
    override var updatedAt: Instant = Instant.now(),


    // --- Composite Keys


    @ColumnInfo(name = "subject_id")
    val subjectId: UUID,


    @ColumnInfo(name = "teacher_id")
    val teacherId: UUID,


    ) : Auditable {
    companion object {
        private const val TAG = "SubjectTeacher"
    }
}