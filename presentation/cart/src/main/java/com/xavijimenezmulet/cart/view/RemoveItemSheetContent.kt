package com.xavijimenezmulet.cart.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xavijimenezmulet.theme.*
import com.xavijimenezmulet.theme.R
import com.xavijimenezmulet.entity.cart.Cart

@Composable
fun RemoveBottomSheetContent(
    cart: Cart?,
    onApprove: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MobileChallengeColors.primary)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.text_cart_delete),
                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.Bold,
                    color = Red,
                    fontSize = 18.sp
                )
                Text(
                    text = cart?.name.orEmpty(),
                    modifier = Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.SemiBold,
                    color = MobileChallengeColors.onTertiary
                )
            }

            TextButton(
                onClick = { onCancel() },
                modifier = Modifier.padding(end = 8.dp),
                contentPadding = PaddingValues(
                    start = 6.dp,
                    top = 0.dp,
                    end = 10.dp,
                    bottom = 0.dp
                ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_circle),
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Red700
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    text = stringResource(id = R.string.text_cancel),
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Normal,
                    color = MobileChallengeColors.onTertiary
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        Text(
            text = stringResource(
                id = R.string.text_delete_cart_description,
                cart?.name.orEmpty()
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            fontWeight = FontWeight.Normal,
            color = MobileChallengeColors.onTertiary
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        Button(
            onClick = {
                onApprove.invoke()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Red),
            shape = RectangleShape
        ) {
            Text(
                text = stringResource(id = R.string.text_approve_remove),
                color = White,
                modifier = Modifier.padding(4.dp)
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
    }
}