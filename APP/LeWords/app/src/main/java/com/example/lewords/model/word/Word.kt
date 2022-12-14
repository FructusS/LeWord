package com.example.lewords.model.word

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "transcription") val transcription: String?,
    @ColumnInfo(name = "wordoneng") val wordoneng: String?,
    @ColumnInfo(name = "wordonrus") val wordonrus: String?,
    @ColumnInfo(name = "learned") val learned: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeValue(id)
        parcel.writeString(transcription)
        parcel.writeString(wordoneng)
        parcel.writeString(wordonrus)
        parcel.writeByte(if (learned) 1 else 0)

    }

    companion object CREATOR : Parcelable.Creator<Word> {
        override fun createFromParcel(parcel: Parcel): Word {
            return Word(parcel)
        }

        override fun newArray(size: Int): Array<Word?> {
            return arrayOfNulls(size)
        }
    }
}