package uz.future.destination.todokotlin.data.repository

import uz.future.destination.todokotlin.data.db.Note
import uz.future.destination.todokotlin.data.db.NoteDatabase

class NoteRepository(private val database: NoteDatabase) {

    suspend fun insert(note: Note) = database.noteDao().insert(note)

    suspend fun delete(note: Note) = database.noteDao().delete(note)

    suspend fun update(note: Note) = database.noteDao().update(note)

    fun deleteAllNotes() = database.noteDao().deleteAllNotes()

     fun getAllNotes() = database.noteDao().getAllNotes()

}