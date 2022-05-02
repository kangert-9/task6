package ru.geekbrains.data

import ru.geekbrains.App
import ru.geekbrains.data.bd.HistoryEntity
import ru.geekbrains.mvpuser.AppState


class TranslateRepositoryImpl : TranslateRepository {

    private val gitHubApi = WordsApiFactory.create()
    private val roomDb = App.getHistoryDao()

    override suspend fun fetchTranslateByWord(word: String): List<DataModel> {
                if (mapHistoryEntityToSearchResult(roomDb.all()).isEmpty()) {
                    return gitHubApi.searchAsync(word).await()
                } else {
                    return mapHistoryEntityToSearchResult(roomDb.getDataByWord(word))
                }
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            roomDb.insert(it)
        }
    }

    fun mapHistoryEntityToSearchResult(list: List<HistoryEntity>): List<DataModel> {
        val dataModel= ArrayList<DataModel>()
        if (!list.isNullOrEmpty()) {
            for (entity in list) {
                dataModel.add(DataModel(entity.word, null))
            }
        }
        return dataModel
    }

    fun convertDataModelSuccessToEntity(appState: AppState): HistoryEntity? {
        return when (appState) {
            is AppState.Success -> {
                val searchResult = appState.data
                if (searchResult.isNullOrEmpty() || searchResult[0].text.isNullOrEmpty())
                {
                    null
                } else {
                    HistoryEntity(searchResult[0].text!!, null)
                }
            }
            else -> null
        }
    }
}