package com.example.nybooks.data


import com.example.nybooks.data.respose.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTService {

    @GET("lists.json")
    fun getBoooks(
        @Query("api-key") apiKey: String = "CrjqeTyG8fxxmleujhowR4rV3ASNZQrw",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}