package com.example.faisal_notesapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.faisal_notesapp.model.Note


@Dao
interface NotesDao {

    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun getAllNotes() : LiveData<List<Note>>

    @Insert
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

}