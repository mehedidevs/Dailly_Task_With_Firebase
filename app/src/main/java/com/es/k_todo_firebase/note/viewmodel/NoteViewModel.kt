package com.es.k_todo_firebase.note.viewmodel

import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.es.k_todo_firebase.data.model.Note
import com.es.k_todo_firebase.data.repositories.NoteRepository
import com.es.k_todo_firebase.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.logging.Handler
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository

) : ViewModel() {


    val notes = MutableLiveData<UiState<List<Note>>>()
    val addNote = MutableLiveData<UiState<String>>()
    val response = MutableLiveData<UiState<String>>()


    fun getNotes() {
        notes.value = UiState.Loading

        repository.getNotes {
            notes.value = it
        }

    }

    fun addNote(note: Note) {

        notes.value = UiState.Loading

        repository.addNote(note) {
            response.value = it

        }

    }

    fun updateNote(note: Note) {

        notes.value = UiState.Loading

        repository.updateNote(note) {
            response.value = it

        }

    }


    fun deleteNote(note: Note) {

        notes.value = UiState.Loading

        repository.deleteNote(note) {
            response.value = it

        }

    }


}