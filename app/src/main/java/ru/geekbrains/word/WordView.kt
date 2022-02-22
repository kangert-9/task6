package ru.geekbrains.word

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface WordView: MvpView {
    @SingleState
    fun showError()
}