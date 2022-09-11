package com.example.todoapplication.room

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insert(note: Note)

    @Update
     suspend fun update(note: Note)

    @Delete
     suspend fun delete(note: Note)

    @Query("SELECT * FROM notes ORDER BY id  DESC")
     fun getAllNotes(): LiveData<List<Note>>
}