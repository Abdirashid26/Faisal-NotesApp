package com.example.faisal_notesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.faisal_notesapp.model.Note

class NoteAdapter(val context: Context) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    var allNotes = emptyList<Note>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var noteTitle = view.findViewById<TextView>(R.id.noteTitle)
        var noteText = view.findViewById<TextView>(R.id.noteText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(R.layout.my_note_item,parent,false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var nTitle = allNotes.get(position).noteTitle
        var nText = allNotes.get(position).noteText

//        display them now
        holder.noteTitle.text = nTitle
        holder.noteText.text = nText
        holder.itemView.setOnClickListener {
            Intent(context,UpdateNoteActivity::class.java).apply {
                putExtra("note",Note(allNotes.get(position).id,nTitle,nText))
                startActivity(context,this,null)
            }

        }

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }


    fun setData(notes: List<Note>){
        this.allNotes = notes
        notifyDataSetChanged()
    }

}