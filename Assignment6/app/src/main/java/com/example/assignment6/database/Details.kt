package com.example.assignment6.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "family_details")
data class Details(
    @PrimaryKey(autoGenerate = true)
    var personId: Int = 0,

    @ColumnInfo(name = "person_name")
    var personName: String = "",

    @ColumnInfo(name = "father_name")
    var fatherName: String = "",

    @ColumnInfo(name = "mother_name")
    var motherName: String = "",

    @ColumnInfo(name = "phone_number")
    var phoneNumber: String = "",

    @ColumnInfo(name = "email_id")
    var emailId: String = ""
)