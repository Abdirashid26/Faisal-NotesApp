package com.example.faisal_notesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.material.textfield.TextInputEditText

@Entity(tableName = "notes")
data class Note (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var noteTitle : String,
    var noteText: String
        )