package com.otabakoglu.omdbapi.di.module

import dagger.Module

@Module(includes = [NetworkModule::class, ViewModelModule::class])
class AppModule