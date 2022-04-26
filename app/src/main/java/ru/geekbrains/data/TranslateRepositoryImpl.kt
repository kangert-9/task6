package ru.geekbrains.data


class TranslateRepositoryImpl : TranslateRepository {

    private val gitHubApi = WordsApiFactory.create()

    override suspend fun fetchTranslateByWord(word: String): List<DataModel> {
        return gitHubApi.searchAsync(word).await()
    }
}