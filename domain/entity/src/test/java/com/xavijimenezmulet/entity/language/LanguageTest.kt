package com.xavijimenezmulet.entity.language

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author xavierjimenez
 * @since 15/3/23
 * @email xavijimenezmulet@macaqueconsulting.com
 */
class LanguageTest {
    @Test
    fun checkCorrectAttributes() {
        val id = 1
        val code = "en"
        val name = "English"
        val isSelected = false

        val dto = Language(
            id = id,
            code = code,
            name = name,
            isSelected = isSelected
        )

        assertEquals(id, dto.id)
        assertEquals(name, dto.name)
        assertEquals(code, dto.code)
        assertEquals(isSelected, dto.isSelected)
    }
}