package com.example.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapplication.room.Database
import com.example.todoapplication.room.Note
import com.example.todoapplication.room.NoteDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityAdd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val title = findViewById<EditText>(R.id.add_title)
        val  detail = findViewById<EditText>(R.id.add_detail)
        val  image = findViewById<ImageView>(R.id.add_img)

        val db = Room.databaseBuilder(
            applicationContext,
            Database::class.java, "note-database"
        ).build()

        GlobalScope.launch { db.noteDao().insert(Note(0, title.toString(), detail.toString(),image.toString())) }

//
//        val noteDao = db.noteDao()
//        val notes: List<Note> = noteDao.getAll()

    }
}