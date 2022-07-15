package com.example.faisal_notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.faisal_notesapp.ViewModel.NotesViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    lateinit var floatingActionButton: FloatingActionButton
    lateinit var notesRecyclerView: RecyclerView
    lateinit var searchNotes:SearchView
    lateinit var notesViewModel:NotesViewModel
    lateinit var notesAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingActionButton = findViewById(R.id.addNote)
        notesRecyclerView = findViewById(R.id.myNotesList)
        searchNotes = findViewById(R.id.searchTxt)

        floatingActionButton.setOnClickListener {
            val intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }

        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)


         notesAdapter = NoteAdapter(this)

        notesRecyclerView.adapter = notesAdapter
        notesRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        notesViewModel.allNotes.observe(this, Observer {
            notes ->
                notesAdapter.setData(notes)
        })


        searchNotes.setOnQueryTextListener(this)
        searchNotes.isSubmitButtonEnabled = true


    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }


    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }

    private  fun searchDatabase(query: String){
        val searchQuery = "%$query%"
        notesViewModel.getSearchResult(searchQuery).observe(this, Observer {
            list ->
            notesAdapter.setData(list)

        })
    }

}