package com.example.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapplication.adapter.RvAdapter
import java.util.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.action_bar));
        val addbtn = findViewById<TextView>(R.id.add)

        addbtn.setOnClickListener() {
            val intent = Intent(this@HomeActivity, ActivityAdd::class.java)
            startActivity(intent)
        }

        val recyclerview = findViewById<RecyclerView>(R.id.rvList);
        recyclerview.layoutManager = LinearLayoutManager(this);

        val adapter = RvAdapter()

        recyclerview.adapter = adapter
    }
}

private fun <E> ArrayList<E>.add(element: E) {

}