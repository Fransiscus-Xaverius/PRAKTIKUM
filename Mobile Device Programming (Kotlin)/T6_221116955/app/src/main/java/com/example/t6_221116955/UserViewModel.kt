package com.example.t6_221116955

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserViewModel() : ViewModel() {
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages

    init {
        createDummyUsers()
    }

    private fun createDummyUsers() {
        val dummyUsers = listOf(
            User("user1", "1", "User One"),
            User("user2", "2", "User Two"),
            User("user3", "3", "User Three"),
            User("user4", "4", "User Four"),
            User("user5", "5", "User Five")
        )

        for (user in dummyUsers) {
            createUser(user.userName, user.password, user.displayName)
        }
    }

    fun createUser(userName: String, password: String, displayName: String) : Boolean{
        if(dataObj.users.find { it.userName == userName } == null) {
            val newUser = User(userName, password, displayName)
            dataObj.users.add(newUser)
            return true
        }
        return false
    }

    fun loginUser(userName: String, password: String): User? {
        for (user in dataObj.users) {
            if (user.userName == userName && user.password == password) {
                dataObj.curUser = user
                return user
            }
        }
        return null
    }

    fun getUserData(user: User): User? {
        return dataObj.users.find { it.userName == user.userName }
    }

    fun addFriend(friend: User) {
        dataObj.curUser?.addFriend(friend)
    }

    fun getFriends(): List<User> {
        return dataObj.curUser?.friends ?: emptyList()
    }

    fun searchUsers(username: String): List<User> {
        val currentUserFriends = dataObj.curUser?.friends ?: emptyList()
        return dataObj.users.filter { it.userName.contains(username, ignoreCase = true) && it !in currentUserFriends && it != dataObj.curUser }
    }

    fun logout() {
        dataObj.curUser = null
    }

    fun getUserByUsername(username: String): User? {
        return dataObj.users.find { it.userName == username }
    }

}

class UserViewModelFactory(private val user: User) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}