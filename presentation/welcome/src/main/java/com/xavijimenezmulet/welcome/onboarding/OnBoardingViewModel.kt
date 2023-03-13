package com.xavijimenezmulet.welcome.onboarding

import androidx.lifecycle.viewModelScope
import com.xavijimenezmulet.framework.base.mvvm.MvvmViewModel
import com.xavijimenezmulet.usecase.welcome.SaveOnBoarding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val saveOnBoarding: SaveOnBoarding
) : MvvmViewModel() {

    fun saveOnBoardingState(completed: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        val params = SaveOnBoarding.Params(completed)
        call(saveOnBoarding(params))
    }
}