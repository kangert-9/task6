package ru.geekbrains.data


interface TranslateRepository {
    suspend fun fetchTranslateByWord(word: String): List<DataModel>
}