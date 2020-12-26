package com.hackernight.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.hackernight.roomdatabase.data.User
import com.hackernight.roomdatabase.data.UserDao
import com.hackernight.roomdatabase.data.UserDatabase

class UserRepository(private val dao: UserDao){

    suspend fun readAllUser() : LiveData<List<User>>{
          return dao.readAllUser()
    }

    suspend fun addUser(user: User){
        dao.addUser(user)
    }
}