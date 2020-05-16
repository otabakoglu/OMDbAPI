package com.otabakoglu.omdbapi.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.otabakoglu.omdbapi.di.CustomViewModelFactory
import com.otabakoglu.omdbapi.di.ViewModelKey
import com.otabakoglu.omdbapi.ui.detail.DetailVM
import com.otabakoglu.omdbapi.ui.main.MainVM
import com.otabakoglu.omdbapi.ui.splash.SplashVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashVM::class)
    abstract fun bindSplashVM(splashVM: SplashVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainVM::class)
    abstract fun bindMainVM(mainVM: MainVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailVM::class)
    abstract fun bindDetailVM(detailVM: DetailVM): ViewModel
}