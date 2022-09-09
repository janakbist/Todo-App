package com.example.todoapplication.room

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
     suspend fun insert(note: Note)

    @Update
     suspend fun update(note: Note)

    @Delete
     suspend fun delete(note: Note)

    @Query("SELECT * FROM notes ORDER BY title,description,image  DESC")
    fun select(): LiveData<List<Note>>
}