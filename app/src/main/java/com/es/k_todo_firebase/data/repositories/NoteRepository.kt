package com.es.k_todo_firebase.data.repositories

import com.es.k_todo_firebase.data.model.Note
import com.es.k_todo_firebase.utils.UiState

interface NoteRepository {
    fun getNotes(result: (UiState<List<Note>>) -> Unit)

    fun addNote(note: Note, result: (UiState<String>) -> Unit)
}