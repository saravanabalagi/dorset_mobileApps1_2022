package com.saravanabalagi.helloworldapplication.dataTypes

import com.saravanabalagi.helloworldapplication.dataTypes.Location

class Post {
    var name: String = "No name given"
    var location: Location = Location()
    var numLikes: Int = 0

    override fun toString(): String {
        return "$name ($location)"
    }
}
