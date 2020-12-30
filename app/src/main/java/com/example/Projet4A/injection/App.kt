package com.example.Projet4A.injection

import android.app.Application
import com.example.projet4A.injection.dataModule
import com.example.projet4A.injection.domainModule
import com.example.projet4A.injection.presentationModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    companion object {
        var hasFetched = false
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(DatabaseModule, NetworkModule, RepositoryModule, ViewModelModule, presentationModule, domainModule, dataModule))
        }
    }
}