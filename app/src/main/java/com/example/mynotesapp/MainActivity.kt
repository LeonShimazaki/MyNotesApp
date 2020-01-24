package com.example.mynotesapp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Year
import java.util.*

const val newNoteResult = 1

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        //recyclerView_main.setBackgroundColor(Color.BLUE)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = mainAdapter

        addButton.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
//        if (v == addButton) {
//            val newNote = NoteModel("1", "2")
//            mainAdapter.addNote(newNote)
//        }
            if (v == addButton){
                val intent = Intent(this, NewNote::class.java)
                startActivityForResult(intent, newNoteResult)
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            newNoteResult -> {
                if (resultCode == Activity.RESULT_OK) {
                    val note = data?.getParcelableExtra<NoteModel>("NewNote")
                    note?.let { mainAdapter.addNote(it) }
                }
            }
        }

    }
}
