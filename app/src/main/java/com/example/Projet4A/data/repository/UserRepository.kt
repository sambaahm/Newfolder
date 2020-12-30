package com.example.Projet4A.data.repository

import com.example.Projet4A.data.local.models.toData
import com.example.Projet4A.data.local.models.toEntity
import com.example.Projet4A.domain.entity.User
import com.example.projet4A.data.local.DatabaseDao


class UserRepository(
        private val databaseDao: DatabaseDao
) {
    suspend fun createUser(user: User) {
    databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User? {
   val userLocal = databaseDao.findByName(email)
           return userLocal?.toEntity()
    }
}