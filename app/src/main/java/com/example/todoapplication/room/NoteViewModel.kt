package com.example.todoapplication.room

import android.app.Application
import android.os.Message
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Node

class NoteViewModel(application: Application) :AndroidViewModel(application) {
    val allNotes:LiveData<List<Note>>
    private val repository: NoteRepository
    init {
        val dao =  NoteDatabase.getDatabase(application).getNoteDao()
         repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNode(note:Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
    fun insertNote(note:Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }
}