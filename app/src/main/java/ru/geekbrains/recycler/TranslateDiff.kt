package ru.geekbrains.recycler

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.geekbrains.data.DataModel

class TranslateDiff : DiffUtil.ItemCallback<DataModel>() {

    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem.text == newItem.text
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }
}