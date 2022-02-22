package ru.geekbrains.mvpuser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.data.TranslateRepository
import ru.geekbrains.data.TranslateRepositoryImpl
import kotlin.random.Random

class TranslateViewModel(var word: String): ViewModel() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repositoryImpl: TranslateRepository = TranslateRepositoryImpl()
    fun getLiveData() = liveDataToObserve

    fun getData() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(1000)
            if(Random.nextBoolean()) {
                liveDataToObserve.postValue(AppState.Success(repositoryImpl.fetchTranslateByWord(word)))
            } else {
                liveDataToObserve.postValue(AppState.Error(Exception("нет интернета")))
            }
        }.start()
    }
}