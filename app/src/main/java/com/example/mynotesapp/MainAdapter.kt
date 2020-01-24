package com.example.mynotesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_row.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>(){
    var x = 0
    var myNotes = mutableListOf(NoteModel("Test", "Content"))

    //numberofitems
    override fun getItemCount(): Int {
        return myNotes.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //how do we even create a view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellView = layoutInflater.inflate(R.layout.note_row, parent, false)
        return CustomViewHolder(cellView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val myNote = myNotes[position]
        holder.view.textTitleRow?.text = myNote.title
        holder.view.textDescriptionRow?.text = myNote.content
    }
    fun addNote(note: NoteModel){
        for (x in 0..100)
            myNotes.add(note)

        notifyDataSetChanged()
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}