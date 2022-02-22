package ru.geekbrains.word

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.App
import ru.geekbrains.R
import ru.geekbrains.data.TranslateRepositoryFactory
import ru.geekbrains.databinding.FragmentWordBinding


class WordFragment : MvpAppCompatFragment(R.layout.fragment_word), WordView {

    private lateinit var viewBinding: FragmentWordBinding
    private val presenter: WordPresenter by moxyPresenter {
        WordPresenter(
            router = App.router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentWordBinding.bind(view)
        viewBinding.button.setOnClickListener {
            presenter.translate(viewBinding.textIn.text.toString())
        }
    }

    companion object {
        fun newInstance(): Fragment = WordFragment()
    }

    override fun showError() {
        Toast.makeText(context, "Поле пустое", LENGTH_SHORT).show()
    }
}