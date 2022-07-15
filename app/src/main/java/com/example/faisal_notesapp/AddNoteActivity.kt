package com.example.faisal_notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.faisal_notesapp.ViewModel.NotesViewModel
import com.example.faisal_notesapp.model.Note
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AddNoteActivity : AppCompatActivity() {

    lateinit var addNote: MaterialButton
    lateinit var  noteTitle : TextInputEditText
    lateinit var noteText : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        addNote = findViewById(R.id.addNote)
        noteTitle = findViewById(R.id.noteTitle)
        noteText = findViewById(R.id.noteText)

        var notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        addNote.setOnClickListener {
            val nTitle = noteTitle.text.toString()
            val nText = noteText.text.toString()

//        create a new note from the class
            val newNote : Note = Note(0,nTitle,nText)
            notesViewModel.addNote(newNote)
            Toast.makeText(this,"Succsesfully added new Note",Toast.LENGTH_SHORT).show()

        }


    }
}