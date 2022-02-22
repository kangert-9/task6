package ru.geekbrains.data.retrofit

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import ru.geekbrains.data.DataModel

interface WordsApi {

    @GET("/{word}")
    fun fetchTranslateByWord(@Path("word") login: String): Observable<List<DataModel>>

}