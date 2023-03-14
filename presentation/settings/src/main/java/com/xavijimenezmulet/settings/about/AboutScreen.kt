package com.xavijimenezmulet.settings.about

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xavijimenezmulet.theme.*
import com.xavijimenezmulet.theme.R
import com.ramcosta.composedestinations.annotation.Destination
import com.xavijimenezmulet.component.ExtraSmallSpacer
import com.xavijimenezmulet.component.MediumSpacer
import com.xavijimenezmulet.component.SmallSpacer
import com.xavijimenezmulet.component.widget.MCToolbarWithNavIcon
import com.xavijimenezmulet.provider.NavigationProvider

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun AboutScreen(
    navigator: NavigationProvider
) {
    val uriHandler = LocalUriHandler.current
    val mediumLink = "https://medium.com/@xavijimenezmulet"
    val githubLink = "https://github.com/xavijimenezmulet"

    Scaffold(
        backgroundColor = MobileChallengeColors.background,
        topBar = {
            MCToolbarWithNavIcon(
                R.string.text_about,
                pressOnBack = {
                    navigator.navigateUp()
                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MobileChallengeColors.surface
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    shape = MobileChallengeShapes.medium,
                    elevation = CardDefaults.elevatedCardElevation()
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(140.dp)
                                .clip(CircleShape)
                        )
                        MediumSpacer()
                        Text(
                            text = "Xevier Jimenez Mulet",
                            style = MobileChallengeTypography.displaySmall,
                            textAlign = TextAlign.Center
                        )
                        ExtraSmallSpacer()
                        Text(
                            text = "Mobile Engineer",
                            style = MobileChallengeTypography.headlineMedium,
                            textAlign = TextAlign.Center
                        )
                        ExtraSmallSpacer()
                        Text(
                            text = "Developed By @xavijimenezmulet",
                            style = MobileChallengeTypography.headlineMedium,
                            textAlign = TextAlign.Center
                        )
                        SmallSpacer()
                        ClickableText(
                            text = AnnotatedString(text = githubLink),
                            style = MobileChallengeTypography.titleLarge,
                            onClick = {
                                uriHandler.openUri(githubLink)
                            }
                        )
                        SmallSpacer()
                        ClickableText(
                            text = AnnotatedString(text = mediumLink),
                            style = MobileChallengeTypography.titleLarge,
                            onClick = {
                                uriHandler.openUri(mediumLink)
                            }
                        )
                    }
                }
            }
        }
    )
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun AboutScreenPreview() {
    MobileChallengeTheme {
        Surface(modifier = Modifier.background(MobileChallengeColors.background)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                shape = MobileChallengeShapes.medium,
                elevation = CardDefaults.elevatedCardElevation()
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(140.dp)
                            .clip(CircleShape)
                    )
                    MediumSpacer()
                    Text(
                        text = "Xevier Jimenez Mulet",
                        style = MobileChallengeTypography.displaySmall,
                        textAlign = TextAlign.Center
                    )
                    ExtraSmallSpacer()
                    Text(
                        text = "Mobile Engineer",
                        style = MobileChallengeTypography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                    ExtraSmallSpacer()
                    Text(
                        text = "Developed By @xavijimenezmulet",
                        style = MobileChallengeTypography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                    SmallSpacer()
                    ClickableText(
                        text = AnnotatedString(text = "https://github.com/xavijimenezmulet"),
                        style = MobileChallengeTypography.titleLarge,
                        onClick = {}
                    )
                    SmallSpacer()
                    ClickableText(
                        text = AnnotatedString(text = "https://medium.com/@xavijimenezmulet"),
                        style = MobileChallengeTypography.titleLarge,
                        onClick = {}
                    )
                }
            }
        }
    }
}