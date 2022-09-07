package com.es.k_todo_firebase.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Note(
    val id: String,
    val noteText: String,

    @ServerTimestamp
    val date: Date

)
