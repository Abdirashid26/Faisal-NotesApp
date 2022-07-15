package com.example.faisal_notesapp.repository

import androidx.lifecycle.LiveData
import com.example.faisal_notesapp.Dao.NotesDao
import com.example.faisal_notesapp.model.Note

class NotesRepo(val notesDao: NotesDao) {

    var allNotes : LiveData<List<Note>> = notesDao.getAllNotes()


    suspend fun addNote(note: Note){
        notesDao.addNote(note)
    }



}