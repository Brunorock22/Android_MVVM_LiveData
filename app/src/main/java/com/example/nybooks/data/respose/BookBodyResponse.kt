package com.example.nybooks.data.respose

import com.google.gson.annotations.SerializedName

data class BookBodyResponse(
    @SerializedName( "results")
    val bookResults : List<BookResultsResponse>
)