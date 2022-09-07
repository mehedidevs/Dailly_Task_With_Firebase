package com.es.k_todo_firebase.data.repositories

import com.es.k_todo_firebase.data.model.Note

interface NoteRepository {
    fun getNotes(): List<Note>
}