package com.xavijimenezmulet.usecase.welcome

import androidx.annotation.VisibleForTesting
import com.xavijimenezmulet.repository.welcome.WelcomeRepository
import com.xavijimenezmulet.framework.base.usecase.ReturnUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *   @author xavierjimenez
 *   @since 8/3/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */
class ReadOnBoarding @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: WelcomeRepository
) : ReturnUseCase<Unit, Boolean>() {

    override suspend fun execute(params: Unit): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}