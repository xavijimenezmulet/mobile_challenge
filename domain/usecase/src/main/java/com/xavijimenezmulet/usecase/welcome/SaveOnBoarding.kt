package com.xavijimenezmulet.usecase.welcome

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.repository.welcome.WelcomeRepository
import com.xavijimenezmulet.framework.base.usecase.LocalUseCase
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 8/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class SaveOnBoarding @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: WelcomeRepository
) : LocalUseCase<SaveOnBoarding.Params, Unit>() {

    data class Params(
        val completed: Boolean
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        repository.saveOnBoardingState(params.completed)
        emit(Unit)
    }
}