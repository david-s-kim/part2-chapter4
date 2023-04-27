package com.example.part2.part2chapter4.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    val username: String,

    @SerializedName("id")
    val id: Int,

    )
