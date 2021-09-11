package com.example.android_basics.architecture_components.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_basics.R
import com.example.android_basics.architecture_components.data.room.entity.Note

class NoteAdapter :
    ListAdapter<Note, NoteAdapter.NoteHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = getItem(position)
        currentNote?.let {
            holder.textViewTitle.text = it.getTitle()
            holder.textViewPriority.text = it.getPriority().toString()
            holder.textViewSubtitle.text = it.getDesc()
        }
    }

    fun getNoteAt(position: Int): Note? {
        return getItem(position)
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById<TextView>(R.id.title)
        val textViewSubtitle: TextView = itemView.findViewById<TextView>(R.id.subtitle)
        val textViewPriority: TextView = itemView.findViewById<TextView>(R.id.priority)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }
        }
    }
}