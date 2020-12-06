package uz.future.destination.todokotlin.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.future.destination.todokotlin.data.repository.NoteRepository


@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(private val repository: NoteRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(repository) as T
    }
}