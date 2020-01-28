package com.example.mynotesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_row.view.*

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    var x = 0

    //Send data to NoteModel List Class from myNotes
    var myNotes = mutableListOf(NoteModel("Test", "Content"))

    //Number of notes in my list
    override fun getItemCount(): Int {
        return myNotes.count()
    }

    //Inflates my view into the recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //how do we even create a view
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellView = layoutInflater.inflate(R.layout.note_row, parent, false)
        return CustomViewHolder(cellView)
    }

    //Binds the Data to the View Holder e.g. Title, Content sticks(positions) onto the the Viewholder
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val position = myNotes[position]
        holder.view.textTitleRow?.text = position.title
        holder.view.textDescriptionRow?.text = position.content
    }

    //Add the note to the List/DB from NoteModel.kt
    fun addNote(note: NoteModel) {
        for (x in 0..100)
            myNotes.add(note)

        notifyDataSetChanged()
    }
}

//A Single Note View being reused
class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view){}