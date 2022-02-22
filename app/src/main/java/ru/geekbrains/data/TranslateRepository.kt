package ru.geekbrains.data

import io.reactivex.rxjava3.core.Observable

interface TranslateRepository {
    fun fetchTranslateByWord(word: String): Observable<List<DataModel>>
}