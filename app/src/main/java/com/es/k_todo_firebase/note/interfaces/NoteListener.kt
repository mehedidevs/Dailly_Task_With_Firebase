package com.es.k_todo_firebase.note.interfaces

import com.es.k_todo_firebase.data.model.Note

interface NoteListener {
    fun onItemClicked(note: Note)
    fun onEditClicked(note: Note)
    fun onDeleteClicked(note: Note)


}