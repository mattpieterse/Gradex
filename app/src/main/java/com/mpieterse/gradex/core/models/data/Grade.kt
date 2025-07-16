package com.mpieterse.gradex.core.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.UUID

@Entity(
    tableName = "grade",
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
data class Grade(

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


    @ColumnInfo(name = "subject_id")
    var subjectId: UUID,


    @ColumnInfo(name = "name")
    var name: String,


    @ColumnInfo(name = "additional_note")
    var additionalNote: String? = null,


    @ColumnInfo(name = "mode")
    var mode: Int = AssignmentMode.UNSET.ordinal,


    @ColumnInfo(name = "type")
    var type: Int = AssignmentType.UNSET.ordinal,


    @ColumnInfo(name = "weighting")
    val weighting: Double,


    @ColumnInfo(name = "mark")
    var mark: Double,


    ) : Keyed, Auditable, Stashable {
    companion object {
        private const val TAG = "Grade"
    }


// --- Functions


    fun getWeightedGrade(): Double = (mark * weighting)
}