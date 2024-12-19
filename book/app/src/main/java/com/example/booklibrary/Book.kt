package com.example.booklibrary.model

import java.io.Serializable

data class Book(
    val title: String,
    val author: String,
    val coverImageUrl: String
) : Serializable

