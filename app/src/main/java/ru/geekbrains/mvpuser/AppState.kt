package ru.geekbrains.mvpuser

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.data.DataModel

sealed class AppState {
    data class Success(val data: List<DataModel>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}