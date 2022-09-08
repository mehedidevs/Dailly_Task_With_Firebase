package com.es.k_todo_firebase.data.repositories

import com.es.k_todo_firebase.data.model.Note
import com.es.k_todo_firebase.utils.Constants
import com.es.k_todo_firebase.utils.UiState
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class NoteRepositoryImp(private val database: FirebaseFirestore) : NoteRepository {


    override fun getNotes(result: (UiState<List<Note>>) -> Unit) {
        database.collection(Constants.NOTE)
            .get()
            .addOnSuccessListener {

                val notes = arrayListOf<Note>();
                for (document in it) {
                    val note = document.toObject(Note::class.java)
                    notes.add(note)

                }

                result.invoke(
                    UiState.Success(notes)

                )

            }.addOnFailureListener {
                result.invoke(
                    UiState.Failure(it.localizedMessage)

                )

            }
    }

    override fun addNote(note: Note, result: (UiState<String>) -> Unit) {
        database.collection(Constants.NOTE)
            .add(note).addOnSuccessListener {
                result.invoke(
                    UiState.Success(it.id)
                )
            }.addOnFailureListener {

                result.invoke(
                    UiState.Failure(it.localizedMessage)

                )
            }


    }

    /*
        override fun getNotes(): UiState<List<Note>> {

        var data = arrayListOf(
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
        data.clear()
        return if (data.isNullOrEmpty()) {

            UiState.Failure("Data is Empty !")
        } else {

            UiState.Success(data)
        }
    }
     */


}