package ru.geekbrains.recycler

import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.data.GitHubUser
import ru.geekbrains.databinding.ViewUserBinding

class UserViewHolder(private val viewBinding: ViewUserBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(user: GitHubUser, onUserClickListener: UsersAdapter.OnUserClickListener?) {
        viewBinding.userLogin.text = user.login
        viewBinding.root.setOnClickListener {
            onUserClickListener?.onUserPicked(user)
        }
    }
}