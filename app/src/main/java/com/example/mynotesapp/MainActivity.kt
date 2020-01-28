package com.example.mynotesapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

//Just a code for the request code to to use onActivityResult
const val newNoteCode = 1

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var mainAdapter = MainAdapter()

    //Create the Page and recycler view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = mainAdapter

        addButton.setOnClickListener(this)
    }

    //Add a Note send to New Note Page
    override fun onClick(v: View?) {
        if (v == addButton) {
            val intent = Intent(this, NewNote::class.java)
            startActivityForResult(intent, newNoteCode)
        }
    }

    //Get Data from the New Note Page using Parcelable
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //check for a code to return from NewNote
        try {
            if (resultCode == Activity.RESULT_OK && requestCode == newNoteCode) {
                val note = data?.getParcelableExtra<NoteModel>("DewNote")
                //let ignores null
                note?.let { mainAdapter.addNote(it) }
            }
        } catch (e: Exception){
            Toast.makeText(this,  "Error", Toast.LENGTH_SHORT).show()
        }
    }
}
