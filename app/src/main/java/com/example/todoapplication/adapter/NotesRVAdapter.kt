package com.example.todoapplication.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import com.example.todoapplication.room.Note
import com.example.todoapplication.room.NoteViewModel

class NotesRVAdapter(private val context:Context, private val listener:INotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    lateinit var viewModel:NoteViewModel
    private val allNotes  = ArrayList<Note>()
    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.text)!!
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)!!
        val editBtnClick = itemView.findViewById<ImageView>(R.id.editBtnClick)!!
        init{
            deleteButton.setOnClickListener {
                listener.onItemClicked(allNotes[adapterPosition])
            }
                editBtnClick.setOnClickListener {
                    val position: Int = getAbsoluteAdapterPosition()
                    val itemsView = LayoutInflater.from(context).inflate(R.layout.activity_update, null)

                    val input = itemsView.findViewById<EditText>(R.id.input)

                    AlertDialog.Builder(context)
                        .setView(itemsView)
                        .setNegativeButton("Cancel"){
                                dialog,_->
                            dialog.dismiss()
                        }
                        .setPositiveButton("Update") { dialog, _ ->
//                    val inputid = itemsView.findViewById<EditText>(R.id.input)
                            val message = input.text.toString()
                            if (message.isNotEmpty()) {
                                listener.onItemClickedUpdate(Note(allNotes[position].id,message))
                                notifyDataSetChanged()
                                dialog.dismiss()
                            }
                        }
                        .create()
                        .show()

                }
            }
        }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        lateinit var viewModel: NoteViewModel



        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text

    }

    fun updateList(newList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    interface INotesRVAdapter {
        fun onItemClicked(note:Note)
        fun onItemClickedUpdate(note: Note)
    }

}