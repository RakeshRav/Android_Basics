package com.example.android_basics.architecture_components.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android_basics.architecture_components.data.room.entity.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAll()

    @Query("SELECT * FROM note_table ORDER BY priority desc")
    fun getAllNotes(): LiveData<List<Note>>
}