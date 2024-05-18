package com.example.notesapp.repository

import com.example.notesapp.database.NoteDB
import com.example.notesapp.model.Note

class NoteRepository(private val db: NoteDB) {

    suspend fun insertNote(note: Note) = db.getNoteQueries().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteQueries().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteQueries().updateNote(note)

    fun getAllNotes() = db.getNoteQueries().getAllNotes()
    fun searchNote(query: String?) = db.getNoteQueries().searchNote(query)
}