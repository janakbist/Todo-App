package com.example.todoapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import java.util.*

class RvAdapter : RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val detail: TextView
        val image: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.item_title)
            detail = view.findViewById(R.id.item_detail)
            image = view.findViewById(R.id.item_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)

        return ViewHolder(view)
    }
    var titles = arrayOf("Title todo work one","Title todo work two","Title todo work third","Title todo work five","Title todo work five","Title todo work five","Title todo work five")
    var details = arrayOf(" Description todo work one","Description todo work two","Description todo work third","Description todo work five","Description todo work five","Description todo work five","Description todo work five")
    val images = intArrayOf(R.drawable.prabhas,R.drawable.prabhas,R.drawable.prabhas,R.drawable.prabhas,R.drawable.prabhas,R.drawable.prabhas,R.drawable.prabhas)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = titles[position];
        holder.detail.text = details[position];
        holder.image.setImageResource(images[position])
    }

    override fun getItemCount() : Int {
        return titles.size
    }

}

private fun ImageView.setImageResource(s: String) {

}
