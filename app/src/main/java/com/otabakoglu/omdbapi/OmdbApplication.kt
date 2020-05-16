package com.otabakoglu.omdbapi

import android.app.Application
import com.otabakoglu.omdbapi.di.component.AppComponent
import com.otabakoglu.omdbapi.di.component.DaggerAppComponent

class OmdbApplication : Application(){

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}