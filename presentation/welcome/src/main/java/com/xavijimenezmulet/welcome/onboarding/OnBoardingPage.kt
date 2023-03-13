package com.xavijimenezmulet.welcome.onboarding

import android.content.Context
import androidx.annotation.DrawableRes
import com.xavijimenezmulet.theme.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    class First(context: Context) : OnBoardingPage(
        image = R.drawable.buy_products,
        title = context.getString(R.string.on_boarding_step_buy_products_title),
        description = context.getString(R.string.on_boarding_step_buy_products_body)
    )

    class Second(context: Context) : OnBoardingPage(
        image = R.drawable.products,
        title = context.getString(R.string.on_boarding_step_products_title),
        description = context.getString(R.string.on_boarding_step_products_body)
    )

    class Third(context: Context) : OnBoardingPage(
        image = R.drawable.disccounts,
        title = context.getString(R.string.on_boarding_step_discount_title),
        description = context.getString(R.string.on_boarding_step_discount_body)
    )
}