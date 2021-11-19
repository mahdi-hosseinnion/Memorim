package com.ssmmhh.memorim.di

import androidx.room.Room
import com.ssmmhh.memorim.persistence.AppDatabase
import com.ssmmhh.memorim.persistence.MemosDao
import com.ssmmhh.memorim.persistence.Migrations
import com.ssmmhh.memorim.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * a hilt module only for cache(persistence) stuff
 */
@Module
@InstallIn(SingletonComponent::class)
object CacheModule {


    @Singleton
    @Provides
    fun provideDataBase(app: BaseApplication): AppDatabase =
        Room.databaseBuilder(
            app.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).addMigrations(Migrations.MIGRATION_1_2).build()


    @Singleton
    @Provides
    fun provideMemosDao(database: AppDatabase): MemosDao = database.memosDao()

}