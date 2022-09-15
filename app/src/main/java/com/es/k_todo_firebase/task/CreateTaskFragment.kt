package com.es.k_todo_firebase.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.es.k_todo_firebase.data.model.Note
import com.es.k_todo_firebase.databinding.FragmentCreateTaskBinding
import com.es.k_todo_firebase.note.viewmodel.NoteViewModel
import com.es.k_todo_firebase.utils.UiState
import com.es.k_todo_firebase.utils.hide
import com.es.k_todo_firebase.utils.show
import com.es.k_todo_firebase.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class CreateTaskFragment : Fragment() {
    lateinit var binding: FragmentCreateTaskBinding

    private val viewModel: NoteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentCreateTaskBinding.inflate(inflater, container, false)
            binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.done.setOnClickListener {

            val sdf = SimpleDateFormat("dd MMM yyyy . hh:mm a")

            val note = Note("", binding.taskEt.text.toString(), Date())


            viewModel.addNote(note)
            viewModel.addNote.observe(viewLifecycleOwner) { state ->
                when (state) {

                    is UiState.Loading -> {
                        binding.progressBar.show()
                        toast("Data Loading...")
                    }
                    is UiState.Failure -> {

                        binding.progressBar.hide()

                        toast(state.error.toString())
                    }
                    is UiState.Success -> {

                        binding.progressBar.hide()
                        toast(state.data)
                    }


                }


            }


        }


    }

}