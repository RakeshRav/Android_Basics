package com.example.android_basics.architecture_components.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.android_basics.architecture_components.data.room.entity.Note
import com.example.android_basics.architecture_components.repository.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository: NoteRepository = NoteRepository(application)
    private val allNotes: LiveData<List<Note>> = noteRepository.getAllNotes()

    fun insert(note: Note) {
        noteRepository.insert(note)
    }

    fun delete(note: Note){
        noteRepository.delete(note)
    }

    fun getAllNotes() = allNotes

}