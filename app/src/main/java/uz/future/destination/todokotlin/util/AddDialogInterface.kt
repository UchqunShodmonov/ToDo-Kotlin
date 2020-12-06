package uz.future.destination.todokotlin.util

import uz.future.destination.todokotlin.data.db.Note

interface  AddDialogInterface{
    fun onAddButtonCLicked(note:Note)
}