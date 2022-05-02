package ru.geekbrains.data

import ru.geekbrains.mvpuser.AppState


interface TranslateRepository {
    suspend fun fetchTranslateByWord(word: String): List<DataModel>
    suspend fun saveToDB(appState: AppState)
}