package com.example.todoapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
data class Note(
    @ColumnInfo(name = "text")val text: String) {
    @PrimaryKey(autoGenerate = true) var id =0
}
