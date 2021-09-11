package com.example.android_basics.architecture_components.data.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.android_basics.architecture_components.data.room.dao.NoteDao
import com.example.android_basics.architecture_components.data.room.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    private class PrePopulateNoteAsyncTask(db: NoteDatabase) :
        AsyncTask<Void, Void, Void>() {

        val noteDao = db.getNoteDao()
        override fun doInBackground(vararg params: Void?): Void? {
            noteDao.insert(Note("Title 1", "Subtitle 1", 1))
            noteDao.insert(Note("Title 2", "Subtitle 2", 2))
            noteDao.insert(Note("Title 3", "Subtitle 3", 3))

            noteDao.insert(Note("Title 1", "Subtitle 1", 4))
            noteDao.insert(Note("Title 2", "Subtitle 2", 5))
            noteDao.insert(Note("Title 3", "Subtitle 3", 5))

            noteDao.insert(Note("Title 1", "Subtitle 1", 6))
            noteDao.insert(Note("Title 2", "Subtitle 2", 8))
            noteDao.insert(Note("Title 3", "Subtitle 3", 9))
            return null
        }
    }

    companion object {
        private lateinit var noteDatabase: NoteDatabase

        private val requestCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PrePopulateNoteAsyncTask(noteDatabase).execute()
            }
        }

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            if (this::noteDatabase.isInitialized.not()) {
                noteDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(requestCallback)
                    .build()
            }
            return noteDatabase
        }
    }
}