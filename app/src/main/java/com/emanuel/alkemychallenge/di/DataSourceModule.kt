package com.emanuel.alkemychallenge.di

import com.emanuel.alkemychallenge.data.TMDb
import com.emanuel.alkemychallenge.data.remote.datasource.IDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
//An annotation that declares which component(s) the annotated class should be included in when Hilt
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    //Identifies a type that the injector only instantiates once. Not inherited.
    @Provides
    //Annotates methods of a module to create a provider method binding. The method's return type is
    // bound to its returned value. The component implementation will pass dependencies to the method as parameters.
    fun provideRetrofit(): Retrofit{
        //Retrofit
        //Retrofit adapts a Java interface to HTTP calls by using annotations on the
        // declared methods to define how requests are made
        return Retrofit.Builder()
            .baseUrl(TMDb.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideIDataSource(retrofit: Retrofit): IDataSource {
        return retrofit.create(IDataSource::class.java)
    }
}