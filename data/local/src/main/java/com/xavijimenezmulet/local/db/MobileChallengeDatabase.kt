package com.xavijimenezmulet.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xavijimenezmulet.local.converter.StringListConverter
import com.xavijimenezmulet.local.dao.ProductsDao
import com.xavijimenezmulet.model.local.products.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringListConverter::class)
abstract class MobileChallengeDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}