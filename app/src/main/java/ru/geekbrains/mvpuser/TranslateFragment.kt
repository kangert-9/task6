package ru.geekbrains.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.App.Navigation.router
import ru.geekbrains.R
import ru.geekbrains.data.DataModel
import ru.geekbrains.data.TranslateRepositoryFactory
import ru.geekbrains.databinding.ViewTranslateBinding
import ru.geekbrains.recycler.TranslateAdapter

class TranslateFragment: MvpAppCompatFragment(R.layout.view_translate), UserView {

    private val wordAdapter = TranslateAdapter()
    private lateinit var viewBinding: ViewTranslateBinding

    private val word: String by lazy {
        arguments?.getString(ARG_WORD).orEmpty()
    }

    private val presenter: TranslatePresenter by moxyPresenter {
        TranslatePresenter(
            word = word,
            wordRepository = TranslateRepositoryFactory.create(),
            router = router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewTranslateBinding.bind(view)
        viewBinding.usersRecycler.adapter=wordAdapter
    }

    override fun showWords(words: List<DataModel>) {
        wordAdapter.submitList(words)
    }

    companion object {
        private const val ARG_WORD = "arg_word"

        fun newInstance(word: String): Fragment =
            TranslateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_WORD, word)
                }
            }
    }
}