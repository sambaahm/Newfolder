package com.example.Projet4A.injection

import android.app.Application
import org.koin.android.ext.android.startKoin

class App: Application() {
    companion object {
        var hasFetched = false
    }
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(DatabaseModule, NetworkModule, RepositoryModule, ViewModelModule))
    }
}