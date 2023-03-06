package com.lukmannudin.olegmoney.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lukmannudin.olegmoney.ui.theme.Dimens


@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color
) {
    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(Dimens.spacing)
                        .clip(CircleShape)
                        .background(selectedColor),
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(Dimens.spacingXXS)
                        .clip(CircleShape)
                        .background(unSelectedColor),
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}