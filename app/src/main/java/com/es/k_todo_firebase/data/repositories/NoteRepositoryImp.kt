package com.es.k_todo_firebase.data.repositories

import com.es.k_todo_firebase.data.model.Note
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class NoteRepositoryImp(val database: FirebaseFirestore) : NoteRepository {

    override fun getNotes(): List<Note> {

        return arrayListOf(
            Note(
                id = "1",
                noteText = "Note1",
                date = Date()
            ),

            Note(
                id = "2",
                noteText = "Note2",
                date = Date()
            ),
            Note(
                id = "3",
                noteText = "Note3",
                date = Date()
            ),
            Note(
                id = "4",
                noteText = "Note4",
                date = Date()
            ),
        )
    }


}