package com.example.todoapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract  fun noteDao() :NoteDao
}