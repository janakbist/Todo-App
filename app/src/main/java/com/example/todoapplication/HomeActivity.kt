package com.example.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.adapter.RvAdapter
import java.util.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.action_bar));

        val recyclerview = findViewById<RecyclerView>(R.id.rvList);
        recyclerview.layoutManager = LinearLayoutManager(this);
        // ArrayList of class ItemsViewModel


        val adapter = RvAdapter()

        recyclerview.adapter = adapter
    }
}

private fun <E> ArrayList<E>.add(element: Int) {

}