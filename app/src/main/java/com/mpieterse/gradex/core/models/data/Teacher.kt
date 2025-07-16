package com.mpieterse.gradex.core.models.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.UUID

@Entity(
    tableName = "teacher",
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
        Index(value = ["name_first", "name_final"], unique = true),
        Index(value = ["degree_id"])
    ]
)
data class Teacher(

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


    @ColumnInfo(name = "name_first")
    var nameFirst: String,


    @ColumnInfo(name = "name_final")
    var nameFinal: String,


    @ColumnInfo(name = "additional_note")
    var additionalNote: String? = null,


    @ColumnInfo(name = "sex")
    var sex: HumanSex = HumanSex.UNSET,


    ) : Keyed, Auditable, Stashable {
    companion object {
        private const val TAG = "Teacher"
    }


// --- Functions


    fun getFullName(): String = "$nameFirst $nameFinal"


    fun getInitials(): String {
        val firstInitial = nameFirst.firstOrNull()?.toString() ?: ""
        val finalInitial = nameFinal.firstOrNull()?.toString() ?: ""
        return if (firstInitial.isNotEmpty() && finalInitial.isNotEmpty()) {
            "$firstInitial$finalInitial".uppercase()
        } else ""
    }
}