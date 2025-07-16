package com.mpieterse.gradex.core.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

@Entity(
    tableName = "project",
    foreignKeys = [
        ForeignKey(
            entity = Subject::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
    indices = [
        Index(value = ["id"], unique = true),
        Index(value = ["subject_id"])
    ]
)
data class Project(

    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: UUID = UUID.randomUUID(),


    @ColumnInfo(name = "created_at")
    override val createdAt: Instant = Instant.now(),


    @ColumnInfo(name = "updated_at")
    override var updatedAt: Instant = Instant.now(),


    @ColumnInfo(name = "stashed_at")
    override var stashedAt: Instant? = null,


    @ColumnInfo(name = "completed_at")
    override var completedAt: Instant? = null,


    @ColumnInfo(name = "name")
    override var name: String,


    @ColumnInfo(name = "additional_note")
    override var additionalNote: String? = null,


    @ColumnInfo(name = "date_of_event")
    override var dateOfEvent: LocalDate,


    @ColumnInfo(name = "time_of_start")
    override var timeOfStart: LocalTime? = null,


    @ColumnInfo(name = "time_of_cease")
    override var timeOfCease: LocalTime? = null,


// --- Attributes


    @ColumnInfo(name = "subject_id")
    var subjectId: UUID,


    @ColumnInfo(name = "mode")
    var mode: AssignmentMode,


    @ColumnInfo(name = "type")
    var type: AssignmentType,


    ) : Event, Completable {
    companion object {
        private const val TAG = "Project"
    }
}