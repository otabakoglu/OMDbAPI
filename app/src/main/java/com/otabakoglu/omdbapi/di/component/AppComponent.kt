package com.otabakoglu.omdbapi.di.component

import android.content.Context
import com.otabakoglu.omdbapi.MainActivity
import com.otabakoglu.omdbapi.di.module.AppModule
import com.otabakoglu.omdbapi.ui.detail.DetailFragment
import com.otabakoglu.omdbapi.ui.main.MainFragment
import com.otabakoglu.omdbapi.ui.splash.SplashFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)

    fun inject(fragment: SplashFragment)
    fun inject(fragment: MainFragment)
    fun inject(fragment: DetailFragment)
}