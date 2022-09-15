package com.es.k_todo_firebase.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.es.k_todo_firebase.R
import com.es.k_todo_firebase.data.model.Note
import com.es.k_todo_firebase.databinding.FragmentNoteDetailsBinding
import com.es.k_todo_firebase.utils.Constants


class NoteDetailsFragment : Fragment() {


    private lateinit var binding: FragmentNoteDetailsBinding
    private lateinit var objectNote: Note

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentNoteDetailsBinding.inflate(inflater, container, false)
            binding.root
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        objectNote = requireArguments().getParcelable("item") ?: Note()
        updateUi()


    }

    private fun updateUi() {
        val type = arguments?.getString("type")

        type.let {
            when (type) {
                Constants.VIEW -> {
                    binding.taskEt.setText(objectNote.noteText)
                }

                Constants.EDIT -> {

                }


            }


        }


    }
}

