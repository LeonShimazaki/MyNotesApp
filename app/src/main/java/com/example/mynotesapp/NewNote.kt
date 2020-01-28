package com.example.mynotesapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_note.*

class NewNote : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_note);

        buttonAddNote.setOnClickListener(this)

    }

    //New note being Created
    override fun onClick(v: View?) {
        if (v == buttonAddNote) {
            val newNote = NoteModel(editNoteTitle.text.toString(), editNoteContent.text.toString())
            val result = Intent()
            result.putExtra("DewNote", newNote)
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}
