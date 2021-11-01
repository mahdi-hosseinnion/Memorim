package com.ssmmhh.memorim.di

import android.content.Context
import com.ssmmhh.memorim.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * App top level module
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * this function provides app context as dependency
     * make future provide function simpler and enable us to use application context anywhere
     */
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context): BaseApplication {
        return context as BaseApplication
    }

    /**
     *  provide this string only to check if hilt works properly
     */
    @Singleton
    @Provides
    fun provideTestString(): String = "Hey if you see this message then hilt did his work properly"

}