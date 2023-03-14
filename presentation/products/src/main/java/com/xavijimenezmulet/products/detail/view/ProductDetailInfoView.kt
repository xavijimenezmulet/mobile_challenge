package com.xavijimenezmulet.products.detail.view

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xavijimenezmulet.component.widget.MCDivider
import com.xavijimenezmulet.entity.products.Product
import com.xavijimenezmulet.theme.*
import com.xavijimenezmulet.theme.R
import com.xavijimenezmulet.utils.extension.toCurrency

@Composable
fun ProductDetailInfoView(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.text_information),
            modifier = Modifier
                .padding(12.dp),
            style = MobileChallengeTypography.titleLarge
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MobileChallengeColors.surface),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                TextRow(
                    key = stringResource(id = R.string.text_name),
                    value = product.name
                )

                MCDivider()

                TextRow(
                    key = stringResource(id = R.string.text_code),
                    value = product.code
                )

                MCDivider()

                TextRow(
                    key = stringResource(id = R.string.text_price),
                    value = product.price?.toCurrency().orEmpty()
                )
            }
        }
    }
}

@Composable
private fun TextRow(key: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = key,
            maxLines = 1,
            overflow = TextOverflow.Visible,
            style = MobileChallengeTypography.bodyMedium,
            textAlign = TextAlign.Start
        )
        Text(
            text = value,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MobileChallengeTypography.titleMedium,
            textAlign = TextAlign.End
        )
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun CharacterDetailInfoViewPreview() {
    MobileChallengeTheme() {
        Surface(color = MobileChallengeColors.background) {
            //CharacterDetailInfoView(Product.init())
        }
    }
}