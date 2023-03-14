package com.xavijimenezmulet.settings.language

import androidx.compose.runtime.mutableStateOf
import com.xavijimenezmulet.entity.language.Language
import com.xavijimenezmulet.framework.base.mvvm.MvvmViewModel
import com.xavijimenezmulet.provider.LanguageProvider
import com.xavijimenezmulet.provider.ResourceProvider
import com.xavijimenezmulet.theme.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    private val languageProvider: LanguageProvider,
    private val resourceProvider: ResourceProvider
) : MvvmViewModel() {

    private var languages = emptyList<Language>()

    val langs = mutableStateOf<List<Language>>(emptyList())

    init {
        languages = getLanguages()
        getLanguage()
    }

    fun saveLanguageCode(code: String) {
        languageProvider.saveLanguageCode(code)
    }

    private fun getLanguageCode(): String {
        return languageProvider.getLanguageCode()
    }

    private fun getLanguage() {
        languages.map {
            it.isSelected = it.code == getLanguageCode()
        }
        langs.value = languages
    }

    private fun getLanguages(): List<Language> {
        return listOf(
            Language(
                id = 1,
                code = "en",
                name = resourceProvider.getString(R.string.text_language_english),
                isSelected = false
            ),
            Language(
                id = 2,
                code = "es",
                name = resourceProvider.getString(R.string.text_language_spanish),
                isSelected = false
            )
        )
    }
}