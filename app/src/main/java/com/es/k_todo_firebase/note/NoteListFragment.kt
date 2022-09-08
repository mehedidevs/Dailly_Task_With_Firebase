package com.es.k_todo_firebase.note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.es.k_todo_firebase.R
import com.es.k_todo_firebase.data.model.Note
import com.es.k_todo_firebase.databinding.FragmentNoteDetailsBinding
import com.es.k_todo_firebase.note.viewmodel.NoteViewModel
import com.es.k_todo_firebase.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    lateinit var binding: FragmentNoteDetailsBinding
    var TAG = "NoteListFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentNoteDetailsBinding.inflate(inflater, container, false)
            return binding.root        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gotoCreatePage.setOnClickListener {

            findNavController().navigate(R.id.action_noteListFragment_to_createTaskFragment)


        }

        noteViewModel.getNotes()
        noteViewModel.notes.observe(viewLifecycleOwner) {
            Log.i("TAG", " Data : $it")

            when (it) {
                is UiState.Loading -> {
                    Log.i(TAG, "Loading.... ")
                }
                is UiState.Failure -> {
                    Log.i(TAG, "Failure ")

                }
                is UiState.Success -> {

                    setDataToUI(it.data)

                }

            }

        }


    }

    private fun setDataToUI(note: List<Note>) {

        val adapter = NoteListingAdapter(note, requireActivity())

        binding.noteRecyclerView.adapter = adapter


    }

}