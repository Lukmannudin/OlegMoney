package com.lukmannudin.olegmoney.ui.layout

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
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.lukmannudin.olegmoney.R
import com.lukmannudin.olegmoney.ui.DotsIndicator
import com.lukmannudin.olegmoney.ui.material.FilledButton
import com.lukmannudin.olegmoney.ui.material.FilledTonalButton
import com.lukmannudin.olegmoney.ui.theme.Dimens
import com.lukmannudin.olegmoney.ui.theme.OlegTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewLogin() {
    OlegTheme {
        val loginText = remember {
            mutableStateOf(LoginPayload(0, 0))
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
                when (pageIndex) {
                    1 -> {
                        loginText.value.apply {
                            titleId = R.string.know_where_your_money_goes
                            descriptionId =
                                R.string.track_your_transaction_easily_with_categories_and_financial_report
                        }
                    }
                    2 -> {
                        loginText.value.apply {
                            titleId = R.string.planning_ahead
                            descriptionId =
                                R.string.setup_your_budget_for_each_category_so_you_in_control
                        }
                    }
                    else -> {
                        loginText.value.apply {
                            titleId = R.string.gain_total_control_of_your_money
                            descriptionId =
                                R.string.become_your_own_money_manager_and_make_every_cent_count
                        }
                    }
                }
                with(loginText.value) {
                    ContentLayout(pageIndex, titleId, descriptionId)
                }
            }

            DotsIndicator(
                totalDots = 3,
                selectedIndex = pagerState.currentPage,
                selectedColor = colorResource(id = R.color.violet),
                unSelectedColor = colorResource(id = R.color.light_violet)
            )

            Spacer(modifier = Modifier.height(Dimens.SpacingXXXL))

            FilledButton(text = stringResource(id = R.string.sign_up)) {}
            FilledTonalButton(text = stringResource(id = R.string.login)) {}
        }
    }
}

@Composable
private fun ContentLayout(
    pageIndex: Int,
    @StringRes titleId: Int,
    @StringRes descriptionId: Int,
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
            painter = painterResource(id = R.drawable.ic_holding_money_big),
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

private data class LoginPayload(
    @StringRes var titleId: Int,
    @StringRes var descriptionId: Int
)