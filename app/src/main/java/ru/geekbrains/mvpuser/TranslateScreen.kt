package ru.geekbrains.mvpuser

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class TranslateScreen(private val userLogin: String): FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        TranslateFragment.newInstance(userLogin)

}