package com.example.t6_221116955

data class User(
    val userName: String,
    val password: String,
    val displayName:String,
    val messages: MutableList<Message> = mutableListOf(),
    val friends: MutableList<User> = mutableListOf() // Add this line
) {
    fun addMessage(message: Message) {
        messages.add(message)
    }

    fun addFriend(friend: User) { // Add this method
        friends.add(friend)
    }
}