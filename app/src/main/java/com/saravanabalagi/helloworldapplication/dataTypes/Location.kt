package com.saravanabalagi.helloworldapplication.dataTypes

class Location {
    var city: String = "No city"
    var country: String = "No country"

    override fun toString(): String {
        return "$city, $country"
    }
}