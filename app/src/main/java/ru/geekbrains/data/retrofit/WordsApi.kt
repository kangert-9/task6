package ru.geekbrains.data.retrofit

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import ru.geekbrains.data.DataModel

interface WordsApi {

    @GET("words/search")
    fun searchAsync (@Query("search") wordToSearch: String): Deferred<List<DataModel>>

}