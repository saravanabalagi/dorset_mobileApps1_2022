package com.saravanabalagi.helloworldapplication.dataTypes

class Post {
    var name: String = "No name given"
    var address: Address = Address()
    var numLikes: Int = 0

    override fun toString(): String {
        return "$name ($address)"
    }
}
