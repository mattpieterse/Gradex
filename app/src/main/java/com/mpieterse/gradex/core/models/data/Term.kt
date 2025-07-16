package com.mpieterse.gradex.core.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDate
import java.util.UUID

@Entity(
    tableName = "term",
    foreignKeys = [
        ForeignKey(
            entity = Degree::class,
            parentColumns = ["id"],
            childColumns = ["degree_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
    indices = [
        Index(value = ["id"], unique = true),
        Index(value = ["degree_id"])
    ]
)
data class Term(

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


    @ColumnInfo(name = "degree_id")
    var degreeId: UUID,


    @ColumnInfo(name = "name")
    var name: String,


    @ColumnInfo(name = "date_of_start")
    var dateOfStart: LocalDate,


    @ColumnInfo(name = "date_of_cease")
    var dateOfCease: LocalDate,


    ) : Keyed, Auditable, Stashable {
    companion object {
        private const val TAG = "Term"
    }
}