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
import kotlinx.android.synthetic.main.new_note.*
import java.time.Year
import java.util.*

class NewNote : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_note);

        buttonAddNote.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == buttonAddNote) {
            val newNote = NoteModel(editNoteTitle.text.toString(), editNoteContent.text.toString())
            val result = Intent()
            result.putExtra("NewNote", newNote)
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}
