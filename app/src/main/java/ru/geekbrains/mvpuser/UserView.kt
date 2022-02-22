package ru.geekbrains.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.data.DataModel

interface UserView : MvpView {
    @SingleState
    fun showWords(words: List<DataModel>)
}