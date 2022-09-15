package com.example.todoapplication

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.adapter.NotesRVAdapter
import com.example.todoapplication.room.Note
import com.example.todoapplication.room.NoteViewModel

class MainActivity : AppCompatActivity(), NotesRVAdapter.INotesRVAdapter {
    lateinit var viewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.action_bar));

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = NotesRVAdapter(this,this)
        recyclerView.adapter = adapter


        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application
        )).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)

            }
        })
    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNode(note)
        Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_SHORT).show()
    }
    override fun onItemClickedUpdate(message: Note) {
        viewModel.updateNote(message)
        Toast.makeText(this,"Data Updated",Toast.LENGTH_SHORT).show()
    }

    fun submitData(view: View) {
        val input = findViewById<EditText>(R.id.input)
        val noteText = input.text.toString()
        if (noteText.isNotEmpty()) {

            viewModel.insertNote(Note(0,noteText))
            Toast.makeText(this,"$noteText Inserted",Toast.LENGTH_SHORT).show()
            input.setText("")
        }
        else{
            Toast.makeText(this,"please write something",Toast.LENGTH_SHORT).show()
        }
    }

}