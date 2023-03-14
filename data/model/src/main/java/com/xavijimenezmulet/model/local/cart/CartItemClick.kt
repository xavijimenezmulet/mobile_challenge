package com.xavijimenezmulet.model.local.cart

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@Entity(tableName = CartItemClickEntity.TABLE_NAME)
class CartItemClickEntity(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_CODE) val code: String,
    @ColumnInfo(name = COLUMN_COUNT) val count: Int,
    @ColumnInfo(name = COLUMN_PROMO) val promo: String,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
    @ColumnInfo(name = COLUMN_PRICE) val price: Float
) {
    companion object {
        const val TABLE_NAME = "cart_item_table"
        const val COLUMN_COUNT = "count"
        const val COLUMN_CODE = "code"
        const val COLUMN_PROMO = "promo"
        const val COLUMN_NAME = "name"
        const val COLUMN_PRICE = "price"
    }
}