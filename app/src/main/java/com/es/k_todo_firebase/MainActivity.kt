package com.es.k_todo_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val user: MutableMap<String, Any> = HashMap()
        user["first"] = "Masum"
        user["last"] = "Mehedi"
        user["born"] = 1988


        FirebaseFirestore.getInstance().collection("user").add(user).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("Tag", "Data added")
            }
        }


    }
}