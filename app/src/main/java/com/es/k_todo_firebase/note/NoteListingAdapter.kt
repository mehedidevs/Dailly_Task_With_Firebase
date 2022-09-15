package com.es.k_todo_firebase.note

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.es.k_todo_firebase.data.model.Note
import com.es.k_todo_firebase.databinding.ItemNoteLayoutBinding
import com.es.k_todo_firebase.note.interfaces.NoteListener
import com.es.k_todo_firebase.note.viewmodel.NoteViewModel_HiltModules

class NoteListingAdapter(

    public val noteListener: NoteListener,
    private val notList: List<Note>,
    private val context: Context
) :
    RecyclerView.Adapter<NoteListingAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteLayoutBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = notList[position]

        holder.binding.edit.setOnClickListener {
            noteListener.onEditClicked(item)
        }

        holder.binding.itemLayout.setOnClickListener {
            noteListener.onItemClicked(note = item)
        }

        holder.bind(item)


    }

    override fun getItemCount(): Int {
        return notList.size
    }


    class NoteViewHolder(val binding: ItemNoteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Note) {
            binding.title.text = item.noteText
            binding.date.text = item.date.toString()

            binding.edit.setOnClickListener {


            }

        }


    }

}