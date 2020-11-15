package com.example.nybooks.data.respose

import com.google.gson.annotations.SerializedName


data class BookResultsResponse(
    @SerializedName("book_details")
    val bookDetalis: List<BookDetailsResponse>
)