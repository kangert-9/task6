package ru.geekbrains.data

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class TranslateRepositoryImpl : TranslateRepository {

    private val gitHubApi = WordsApiFactory.create()

    override fun fetchTranslateByWord(word: String): List<DataModel> {
        return gitHubApi.fetchTranslateByWord(word)
    }
}