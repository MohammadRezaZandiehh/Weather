package com.example.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "students")
class Student {
    @SerializedName("course")
    var course: String? = null

    @SerializedName("created_at")
    var createdAt: String? = null

    @SerializedName("first_name")
    var firstName: String? = null

    @SerializedName("id")
    @PrimaryKey
    var id: Long? = null

    @SerializedName("last_name")
    var lastName: String? = null

    @SerializedName("score")
    var score: Long? = null

    @SerializedName("updated_at")
    var updatedAt: String? = null
}