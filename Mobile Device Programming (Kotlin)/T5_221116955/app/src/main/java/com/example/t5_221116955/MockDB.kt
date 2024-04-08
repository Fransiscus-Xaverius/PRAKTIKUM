package com.example.t5_221116955

class MockDB {
    companion object{
        //Mohon maaf untuk komentar kasarnya waktu tidak cukup buat ngapus :D. I'm pissed at Kotlin. #JavaScriptEnjoyer #C#isbetter #IlikeC++ #BackendEnjoyer
        val listUser = mutableListOf(
            User("48YearManFromSomalia", "40yroldsomalian", "somaliaXOXO"),
            User("HLTV enjoyer", "hltv_enjoyer", "imadegenerate"),
            User("KotlinIsDogWater", "i_hate_kotlin", "deprecatethis"),
            User("JUSTDEPRECATEEVERYTHING", "deprecate_kotlin_as_a_whole", "deprecateall"),
            User("Pink Guy","a","a") //use this as a test.
        )
        val listPost = mutableListOf(
            Post("donk666", "48YearManFromSomalia","Hello am 40 year man from Somalia", "Hello am 48 year old man from somalia. Sorry for my bed england. I selled my wife for internet connection for play “conter stirk” and i want to become the goodest player like you I play with 400 ping on brazil server and I am Global Elite 2. pls no copy pasterino my story..", mutableListOf<String>(), mutableListOf<Reply>()),
            Post ("donkcheating", "HLTV enjoyer", "donk666 skilled player but that is not normally", "donk666 skilled player but that is not normally, This very very insane....They need to check him pc and game.....Maybe he not cheating but maybe he using the game deficit ...and this cant seem on game screen..He needs to check-up....donk666 FPL Cheater with Streaming.....I think donk666 still cheating...donk666 using game deficit on PRO scene ,ON BIG Events.Maybe everyone dont knows him trick.He incredible....I want to ask his where is the comming of your skill's ?", mutableListOf<String>(), mutableListOf<Reply>()),
            Post("stopusingkotlin", "KotlinIsDogWater","I hate Kotlin as a whole", "Why do people like this language? I don't get why would you use a language that deprecates everything that is good.", mutableListOf<String>(), mutableListOf<Reply>()),
            Post("deprecateeverything", "deprecate_kotlin_as_a_whole", "please stop deprecating functions that I use ", "I hate jetbrains", mutableListOf<String>(), mutableListOf<Reply>()),
            Post("a","Pink GUy","HELP!","I think there's something wrong with me cause all I see is death. Everytime I go outside I look like I've been doing meth and I sleep for 19 hours on a thursday afternoon. Every now and then I cough up blood and I don't know what to do" , mutableListOf<String>(), mutableListOf<Reply>())
        )

        var currentUser:User? = null //store current logged in user.
        var currentTopic:Post? = null //store current viewed topic

        fun getUser(username: String): User? {
            return listUser.find { it.username == username }
        }

        fun generateRandomString(length: Int): String {
            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }

        fun addUser(u:User){
            listUser.add(u)
        }
        fun addPost(t:String, c:String, author:String){
            var temp = generateRandomString(10)
            while(postIDExist(temp)){
                temp = generateRandomString(10)
            }
            listPost.add(0,Post(temp,author,t,c, mutableListOf<String>(), mutableListOf<Reply>()))
        }
        fun addReply(p:Post, r:Reply){

        }

        fun postIDExist(ID: String): Boolean {
            return listPost.count { it.id == ID } >= 1
        }

        fun usernameExist(username: String): Boolean {
            return listUser.count { it.username == username } >= 1
        }

    }
}