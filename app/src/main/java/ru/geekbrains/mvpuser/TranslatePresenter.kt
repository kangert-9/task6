package ru.geekbrains.mvpuser

import moxy.MvpPresenter
import ru.geekbrains.data.TranslateRepository
import ru.geekbrains.navigation.CustomRouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class TranslatePresenter(
    private val word: String,
    private val wordRepository: TranslateRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        updateContent()
//        userRepository
//            .getUserByLogin(userLogin)
//            ?.let(viewState::showUser)
    }

    private fun updateContent() {
        wordRepository.fetchTranslateByWord(word)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showWords(it)
            },{
                val errorMessage = it.message
                //DisplayError
            })
    }
}