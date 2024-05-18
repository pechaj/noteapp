package com.example.notesapp.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.notesapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDB : RoomDatabase() {

    abstract fun getNoteQueries(): NoteDBQueries

    companion object {
        @Volatile
        private var instance: NoteDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK) {
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDB::class.java,
                "note_db"
            ).build()
    }
}

