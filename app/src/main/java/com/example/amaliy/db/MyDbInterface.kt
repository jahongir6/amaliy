package com.example.amaliy.db

import com.example.amaliy.models.User

interface MyDbInterface {
    fun addUser(user: User)
    fun getAllUser():List<User>
}