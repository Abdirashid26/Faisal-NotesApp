package com.example.faisal_notesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.faisal_notesapp.database.NoteDatabase
import com.example.faisal_notesapp.model.Note
import com.example.faisal_notesapp.repository.NotesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var allNotes:LiveData<List<Note>>
    lateinit var notesRepo: NotesRepo

    init {

        val notesDao = NoteDatabase.getDatabase(application).getNotesDao()
        notesRepo = NotesRepo(notesDao)
        allNotes = notesRepo.allNotes
    }



    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            notesRepo.addNote(note)
        }
    }


}