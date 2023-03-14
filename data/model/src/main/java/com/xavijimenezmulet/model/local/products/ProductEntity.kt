package com.xavijimenezmulet.model.local.products

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ProductEntity.TABLE_NAME)
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) val id: Int?,
    @ColumnInfo(name = COLUMN_NAME) val name: String?,
    @ColumnInfo(name = COLUMN_CODE) val code: String?,
    @ColumnInfo(name = COLUMN_PRICE) val price: Float?,
) {
    companion object {
        const val TABLE_NAME = "product_table"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_CODE = "code"
        const val COLUMN_PRICE = "price"
    }
}