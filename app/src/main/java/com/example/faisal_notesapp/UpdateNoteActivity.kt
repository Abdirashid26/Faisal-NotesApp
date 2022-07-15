
package com.example.faisal_notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.Delete
import com.example.faisal_notesapp.ViewModel.NotesViewModel
import com.example.faisal_notesapp.model.Note
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.delay

class UpdateNoteActivity : AppCompatActivity() {

    lateinit var noteTitle:TextInputEditText
    lateinit var noteText: TextInputEditText
    lateinit var updateButton: MaterialButton
    lateinit var deleteButton: MaterialButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)

        noteTitle = findViewById(R.id.noteTitle)
        noteText = findViewById(R.id.noteText)
        updateButton = findViewById(R.id.updateNote)
        deleteButton = findViewById(R.id.deleteNote)

        val notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)


        var note: Note = intent.getSerializableExtra("note") as Note


        noteTitle.setText(note.noteTitle)
        noteText.setText(note.noteText)


        updateButton.setOnClickListener{

            note.noteTitle = noteTitle.text.toString()
            note.noteText = noteText.text.toString()


            notesViewModel.updateNote(note)
            Toast.makeText(this,"Updated Note Successfully",Toast.LENGTH_SHORT).show()
            finish()

        }

        deleteButton.setOnClickListener {
            notesViewModel.deleteNote(note)
            Toast.makeText(this,"Deleted Note successfully",Toast.LENGTH_SHORT).show()
            finish()
        }


    }
}