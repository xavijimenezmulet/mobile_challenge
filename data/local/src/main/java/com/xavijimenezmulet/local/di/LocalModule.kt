package com.xavijimenezmulet.local.di

import android.content.Context
import androidx.room.Room
import com.xavijimenezmulet.local.dao.cart.CartDao
import com.xavijimenezmulet.local.dao.products.ProductsDao
import com.xavijimenezmulet.local.db.MobileChallengeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

private const val DB_NAME = "db_name"

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    @Named(value = DB_NAME)
    fun provideDatabaseName(): String {
        return DB_NAME
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @Named(value = DB_NAME) dbname: String,
        @ApplicationContext context: Context
    ): MobileChallengeDatabase {
        return Room.databaseBuilder(context, MobileChallengeDatabase::class.java, dbname)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideProductsDao(appDatabase: MobileChallengeDatabase): ProductsDao {
        return appDatabase.productsDao()
    }

    @Provides
    @Singleton
    fun provideCartDao(appDatabase: MobileChallengeDatabase): CartDao {
        return appDatabase.cartDao()
    }
}