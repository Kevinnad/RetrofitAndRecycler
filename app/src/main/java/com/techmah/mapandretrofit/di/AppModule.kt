package com.app.map.di


import com.techmah.mapandretrofit.interfaces.Services
import com.techmah.mapandretrofit.network.HttpClientBuilderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesService(httpClient: HttpClientBuilderFactory): Services = Services.createService(httpClient)


    @Provides
    @Singleton
    fun provideHttpBuilderFactory() : HttpClientBuilderFactory = HttpClientBuilderFactory()



}