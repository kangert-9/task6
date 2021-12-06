package ru.geekbrains.data

interface GitHubUserRepository {

    fun getUsers(): List<GitHubUser>

    fun getUserByLogin(userId: String): GitHubUser?

}