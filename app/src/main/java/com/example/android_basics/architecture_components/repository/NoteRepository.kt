package com.example.android_basics.architecture_components.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.android_basics.architecture_components.data.room.NoteDatabase
import com.example.android_basics.architecture_components.data.room.dao.NoteDao
import com.example.android_basics.architecture_components.data.room.entity.Note

class NoteRepository(application: Application) {
    private var noteDao: NoteDao = NoteDatabase.getInstance(application).getNoteDao()
    private var allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    fun insert(note: Note) {
        InsertNoteAsyncTask(noteDao).execute(note)
    }

    fun update(note: Note) {

    }

    fun delete(note: Note) {
        DeleteNoteAsyncTask(noteDao).execute(note)
    }

    fun deleteAll() {

    }

    fun  getAllNotes() = allNotes

    //we have to create a static inner class, so that it does not hold the reference to this note repository
    private class InsertNoteAsyncTask(private val noteDao: NoteDao) :
        AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg params: Note?): Void? {
            params[0]?.let { noteDao.insert(it) }
            return null
        }
    }

    //we have to create a static inner class, so that it does not hold the reference to this note repository
    private class DeleteNoteAsyncTask(private val noteDao: NoteDao) :
        AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg params: Note?): Void? {
            params[0]?.let { noteDao.delete(it) }
            return null
        }
    }
}