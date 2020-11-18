package com.example.nybooks.data.respose

import com.example.nybooks.data.model.Book
import com.google.gson.annotations.SerializedName


data class BookDetailsResponse(
    @SerializedName( "title")
    val title: String,
    @SerializedName( "author")
    val author: String,
    @SerializedName( "description")
    val description: String
){
    fun getBookModel() = Book(title = this.title, author = this.author, description = this.description)
}