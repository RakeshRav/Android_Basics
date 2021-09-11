package com.example.android_basics.architecture_components.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(
    private var title: String?,
    @ColumnInfo(name = "description")
    private var desc: String?,
    private var priority: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null

    fun getTitle() = title
    fun getDesc() = desc
    fun getPriority() = priority


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if(other !is Note) return false

        if (title != other.title) return false
        if (desc != other.desc) return false
        if (priority != other.priority) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title?.hashCode() ?: 0
        result = 31 * result + (desc?.hashCode() ?: 0)
        result = 31 * result + priority
        result = 31 * result + (id ?: 0)
        return result
    }
}