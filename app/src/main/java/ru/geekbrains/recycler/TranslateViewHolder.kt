package ru.geekbrains.recycler

import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.data.DataModel
import ru.geekbrains.databinding.ItemBinding

class TranslateViewHolder(private val viewBinding: ItemBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(word: DataModel) {
        viewBinding.translateWord.text = word.meanings.toString()
    }
}