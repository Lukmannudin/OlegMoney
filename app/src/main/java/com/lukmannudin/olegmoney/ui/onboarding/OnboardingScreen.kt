package com.lukmannudin.olegmoney.ui.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.lukmannudin.olegmoney.R
import com.lukmannudin.olegmoney.ui.DotsIndicator
import com.lukmannudin.olegmoney.ui.material.PrimaryButton
import com.lukmannudin.olegmoney.ui.material.PlainButton
import com.lukmannudin.olegmoney.ui.material.SecondaryButton
import com.lukmannudin.olegmoney.ui.theme.Dimens
import com.lukmannudin.olegmoney.ui.theme.OlegTheme


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OlegTheme {
        OnboardingScreen(
            onNavigateToSignup = {},
            onNavigateToLogin = {}
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    onNavigateToSignup: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    OlegTheme {
        val content = remember {
            mutableStateOf(ViewLoginContent(0, 0, 0))
        }

        val pagerState = rememberPagerState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.spacingXS, vertical = Dimens.SpacingXXXL),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                modifier = Modifier.weight(1f),
                state = pagerState,
                count = 3
            ) { pageIndex ->
                content.value = contentByState(pageIndex)

                with(content.value) {
                    ContentLayout(
                        iconRes = iconRes,
                        titleId = titleId,
                        descriptionId = descriptionId
                    )
                }
            }

            DotsIndicator(
                totalDots = 3,
                selectedIndex = pagerState.currentPage,
                selectedColor = colorResource(id = R.color.violet),
                unSelectedColor = colorResource(id = R.color.light_violet)
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingXXXL))

            PrimaryButton(text = stringResource(id = R.string.sign_up)) { onNavigateToSignup.invoke() }

            Spacer(modifier = Modifier.height(Dimens.spacing))

            SecondaryButton(text = stringResource(id = R.string.login)) { onNavigateToLogin.invoke() }
        }
    }
}

private fun contentByState(pageIndex: Int): ViewLoginContent {
    return when (pageIndex) {
        1 -> {
            ViewLoginContent(
                iconRes = R.drawable.ic_money_flow,
                titleId = R.string.know_where_your_money_goes,
                descriptionId =
                R.string.track_your_transaction_easily_with_categories_and_financial_report
            )
        }
        2 -> {
            ViewLoginContent(
                iconRes = R.drawable.ic_plan,
                titleId = R.string.planning_ahead,
                descriptionId =
                R.string.setup_your_budget_for_each_category_so_you_in_control
            )
        }
        else -> {
            ViewLoginContent(
                iconRes = R.drawable.ic_holding_money_big,
                titleId = R.string.gain_total_control_of_your_money,
                descriptionId =
                R.string.become_your_own_money_manager_and_make_every_cent_count
            )
        }
    }
}

@Composable
private fun ContentLayout(
    @DrawableRes iconRes: Int,
    @StringRes titleId: Int,
    @StringRes descriptionId: Int
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(Dimens.spacingXXL),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val imageModifier = Modifier
            .size(132.dp)


        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )
        Spacer(modifier = Modifier.height(Dimens.SpacingXXXXL))

        Text(
            text = stringResource(id = titleId),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Dimens.SpacingXL))

        Text(
            text = stringResource(id = descriptionId),
            textAlign = TextAlign.Center
        )
    }
}

private data class ViewLoginContent(
    @DrawableRes var iconRes: Int,
    @StringRes var titleId: Int,
    @StringRes var descriptionId: Int
)