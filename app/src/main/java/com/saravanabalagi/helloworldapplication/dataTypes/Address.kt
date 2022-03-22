package com.saravanabalagi.helloworldapplication.dataTypes

class Address {
    var street: String = "No street"
    var city: String = "No city"

    override fun toString(): String {
        return "$street, $city"
    }
}