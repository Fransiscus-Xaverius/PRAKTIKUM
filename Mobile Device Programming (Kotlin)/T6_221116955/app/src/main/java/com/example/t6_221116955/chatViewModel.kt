package com.example.t6_221116955

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Message(
    val sender: User,
    val receiver: User,
    val messageText: String,
    val type: MessageType
)

enum class MessageType {
    INCOMING,
    OUTGOING
}

class chatViewModel: ViewModel() {
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages

    fun newMessage(sender: User, receiver: User, messageText: String) {
        val sentmessage = Message(sender, receiver, messageText, MessageType.OUTGOING)
        val incomingmessage = Message(receiver, sender, messageText, MessageType.INCOMING)
        dataObj.curUser?.addMessage(sentmessage)
        dataObj.tarUser?.addMessage(incomingmessage)
    }

    fun getMessages(receiver: User, sender: User): MutableList<Message> {
        val filteredMessages = sender.messages.filter { it.receiver == receiver }
        return filteredMessages as MutableList<Message>
    }

    fun getLastMessage(sender: User, receiver: User): Message? {
        val filteredMessages = sender.messages.filter { (it.sender == sender && it.receiver == receiver) || (it.sender == receiver && it.receiver == sender) }.lastOrNull()
        return filteredMessages
    }

}