package com.example.projet4A.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.Projet4A.data.local.models.UserLocal


@Database(entities = arrayOf(UserLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}
