package com.es.k_todo_firebase.data.model

import android.os.Parcelable
import com.google.firebase.firestore.ServerTimestamp
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.util.*

@Parcelize
data class Note(
    var id: String = "",
    val noteText: String = "",

    @ServerTimestamp
    val date: Date = Date()

) : Parcelable
