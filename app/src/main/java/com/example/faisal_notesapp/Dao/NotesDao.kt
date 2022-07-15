package com.example.faisal_notesapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.faisal_notesapp.model.Note


@Dao
interface NotesDao {

    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun getAllNotes() : LiveData<List<Note>>

    @Insert
    fun addNote(note: Note)

}