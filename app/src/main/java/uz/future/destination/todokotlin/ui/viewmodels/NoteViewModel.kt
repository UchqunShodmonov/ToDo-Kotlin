package uz.future.destination.todokotlin.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.future.destination.todokotlin.data.db.Note
import uz.future.destination.todokotlin.data.repository.NoteRepository

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {

    fun insert(note: Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(note)
    }


    fun update(note: Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.update(note)
    }

    fun delete(note: Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(note)
    }

    fun deleteAllNotes() = repository.deleteAllNotes()

    fun getAllNotes() = repository.getAllNotes()

}