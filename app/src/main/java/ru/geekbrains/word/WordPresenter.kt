package ru.geekbrains.word

import moxy.MvpPresenter
import ru.geekbrains.mvpuser.TranslateScreen
import ru.geekbrains.navigation.CustomRouter

class WordPresenter(
    private val router: CustomRouter
): MvpPresenter<WordView>() {

    fun translate(word: String?) {
        if (word==null){
            viewState.showError()
        } else {
            router.navigateTo(TranslateScreen(word))
        }
    }
}