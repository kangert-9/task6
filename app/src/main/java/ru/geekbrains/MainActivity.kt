package ru.geekbrains

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.App.Navigation.navigatorHolder
import ru.geekbrains.App.Navigation.router
import ru.geekbrains.navigation.CustomNavigator
import ru.geekbrains.word.WordScreen

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.navigateTo(WordScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}