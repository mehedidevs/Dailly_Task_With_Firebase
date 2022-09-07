package com.es.k_todo_firebase.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.es.k_todo_firebase.data.model.Note
import com.es.k_todo_firebase.data.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository

) : ViewModel() {

    init {
        getNotes()
    }

    private val _notes = MutableLiveData<List<Note>>()

     val note: LiveData<List<Note>>
        get() = _notes


    private fun getNotes() {
        _notes.value = repository.getNotes()
    }


}