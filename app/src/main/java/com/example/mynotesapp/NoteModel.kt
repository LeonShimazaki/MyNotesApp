package com.example.mynotesapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NoteModel(
    var title: String,
    var content: String
) : Parcelable
