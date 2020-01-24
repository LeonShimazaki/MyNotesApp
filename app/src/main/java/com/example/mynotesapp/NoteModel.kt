package com.example.mynotesapp

import android.os.Parcel
import android.os.Parcelable

class NoteModel(
    var title: String,
    var content: String
): Parcelable
{
    constructor(source: Parcel) : this(
        source.readString() ?: "",
        source.readString() ?: ""
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(title)
        writeString(content)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NoteModel> = object : Parcelable.Creator<NoteModel> {
            override fun createFromParcel(source: Parcel): NoteModel = NoteModel(source)
            override fun newArray(size: Int): Array<NoteModel?> = arrayOfNulls(size)
        }
    }
}
