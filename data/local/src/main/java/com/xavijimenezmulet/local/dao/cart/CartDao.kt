package com.xavijimenezmulet.local.dao.cart

import androidx.room.Dao
import androidx.room.Query
import com.xavijimenezmulet.framework.base.room.dao.BaseDao
import com.xavijimenezmulet.model.local.cart.CartItemClickEntity

/**
 *   @author xavierjimenez
 *   @since 14/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
@Dao
interface CartDao : BaseDao<CartItemClickEntity> {
    @Query("SELECT * FROM ${CartItemClickEntity.TABLE_NAME} ORDER BY name")
    suspend fun getCartItemList(): List<CartItemClickEntity>

    @Query("SELECT * FROM ${CartItemClickEntity.TABLE_NAME} WHERE code = :code")
    suspend fun getCartItem(code: String): CartItemClickEntity?

    @Query("DELETE FROM ${CartItemClickEntity.TABLE_NAME} WHERE code = :code")
    suspend fun deleteItem(code: String)

    @Query("DELETE FROM ${CartItemClickEntity.TABLE_NAME}")
    suspend fun deleteCartList()
}