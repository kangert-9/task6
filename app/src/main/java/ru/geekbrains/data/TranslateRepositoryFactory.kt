package ru.geekbrains.data

object TranslateRepositoryFactory {
    fun create(): TranslateRepository = TranslateRepositoryImpl()
}