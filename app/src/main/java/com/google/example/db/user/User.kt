package com.google.example.db.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class User (@PrimaryKey(autoGenerate = true) var uid: Int? = null,
            @ColumnInfo(name = "first_name") var firstName: String?,
            @ColumnInfo(name = "last_name") var lastName: String?)