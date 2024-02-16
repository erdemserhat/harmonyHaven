package com.erdemserhat.harmonyhaven.presentation.home


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.erdemserhat.harmonyhaven.R
import com.erdemserhat.harmonyhaven.domain.model.MostReadArticleModel
import com.erdemserhat.harmonyhaven.domain.model.OnBoardingPage
import com.erdemserhat.harmonyhaven.presentation.appcomponents.HarmonyHavenGreetingButton
import com.erdemserhat.harmonyhaven.presentation.appcomponents.HarmonyHavenGreetingTitle
import com.erdemserhat.harmonyhaven.presentation.welcome.PagerScreen
import com.erdemserhat.harmonyhaven.ui.theme.harmonyHavenComponentWhite
import com.erdemserhat.harmonyhaven.ui.theme.harmonyHavenDarkGreenColor
import com.erdemserhat.harmonyhaven.ui.theme.harmonyHavenGradientGreen
import com.erdemserhat.harmonyhaven.ui.theme.harmonyHavenGradientWhite
import com.erdemserhat.harmonyhaven.ui.theme.harmonyHavenGreen
import com.erdemserhat.harmonyhaven.ui.theme.harmonyHavenTitleTextColor
import com.erdemserhat.harmonyhaven.ui.theme.harmonyHavenWhite
import com.erdemserhat.harmonyhaven.util.Constants
import com.erdemserhat.harmonyhaven.util.customFontFamilyJunge
import com.erdemserhat.harmonyhaven.util.customFontInter


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        harmonyHavenGradientGreen,
                        harmonyHavenGradientWhite
                    )
                )
            )
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        GreetingHarmonyHavenComponent()
        //HarmonyHavenSearchBarPrototype1()
        HarmonyHavenSearchBarPrototype2(modifier = Modifier.padding(bottom = 20.dp))
        MostReadHorizontalPager()
        ContentColumn(Modifier.padding(top = 25.dp))


    }


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)


}

@Composable
fun GreetingHarmonyHavenComponent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.basicline),
                contentDescription = null
            )
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.harmony_haven_icon),
                    contentDescription = null,
                    Modifier.size(80.dp)

                )
                Spacer(modifier = Modifier.size(10.dp))


                Text(
                    text = "HARMONY HAVEN",
                    modifier = Modifier,
                    fontFamily = customFontFamilyJunge,
                    color = harmonyHavenDarkGreenColor


                )

            }

            Image(
                painter = painterResource(id = R.drawable.basicline),
                contentDescription = null
            )
        }

        Text(
            text = stringResource(R.string.daily_greeting_text),
            textAlign = TextAlign.Center,
            color = harmonyHavenDarkGreenColor,
            modifier = Modifier.padding(top = 10.dp)
        )


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HarmonyHavenSearchBarPrototype1() {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    var active by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .semantics {
                isTraversalGroup = false
            },
        contentAlignment = Alignment.TopCenter
    ) {
        androidx.compose.material3.SearchBar(
            colors = SearchBarDefaults.colors(
                containerColor = harmonyHavenComponentWhite,
                dividerColor = harmonyHavenDarkGreenColor

            ),
            query = text,
            onQueryChange = { text = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = { Text(text = "Search...") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            //trailingIcon = { Icon(imageVector = Icons.Default.MoreVert, contentDescription = null) }

        ) {
            repeat(4) { idx ->
                val resultText = "Suggestion $idx"
                ListItem(
                    headlineContent = { Text(text = resultText) },
                    supportingContent = { Text(text = "Additional Info") },
                    leadingContent = {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .clickable {
                            text = resultText
                            active = false
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)

                )

            }

        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HarmonyHavenSearchBarPrototype2(modifier: Modifier) {
    var text by rememberSaveable {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .semantics {
                isTraversalGroup = false
            },
        contentAlignment = Alignment.TopCenter
    ) {
        androidx.compose.material3.SearchBar(
            colors = SearchBarDefaults.colors(
                containerColor = harmonyHavenComponentWhite,
                dividerColor = harmonyHavenDarkGreenColor

            ),
            query = text,
            onQueryChange = { text = it },
            onSearch = { }, // Arama butonuna basıldığında arama çubuğunun aktifliği sıfırlanır
            active = false,
            onActiveChange = { },
            placeholder = { Text(text = "Search...") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            //trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) }
        ) {
            // Arama önerileri burada
        }
    }
}

@Preview
@Composable
fun MostReadContentPreview() {
    ContentColumn(Modifier)
}


@Composable
fun MostReadArticle(article:MostReadArticleModel) {
    Box(
        modifier = Modifier
            .size(width = 350.dp, height = 200.dp)
            .background(harmonyHavenComponentWhite, shape = RoundedCornerShape(15.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = article.title,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = FontWeight.Bold,
                fontFamily = customFontInter,
                color = harmonyHavenDarkGreenColor,
                modifier = Modifier
                    .padding(10.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                Modifier.size(width = 360.dp, height = 110.dp)
            ) {
                Image(
                    painter = painterResource(id = article.image),
                    contentDescription = null,
                    Modifier
                        .size(120.dp)
                        .padding(start = 10.dp, end = 10.dp)
                )
                Text(
                    text = article.description,
                    fontFamily = customFontInter,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(end = 10.dp, bottom = 10.dp)


                )

            }
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 10.dp, end = 10.dp)

                .size(width = 100.dp, height = 35.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = harmonyHavenGreen
            )

        ) {
            Text(
                text = "Read",
                textAlign = TextAlign.Center,
                fontFamily = customFontInter,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.CenterVertically)


            )

        }


    }
}

@Composable
fun MostReadHorizontalList() {
    Column {

        Text(
            text = "Most Read",
            modifier = Modifier
                .padding(start = 16.dp, bottom = 10.dp),
            fontFamily = customFontInter,
            fontWeight = FontWeight.Bold,
            color = harmonyHavenTitleTextColor,
            fontSize = MaterialTheme.typography.titleMedium.fontSize

        )
        LazyRow(
            Modifier.padding(start = 16.dp)
        ) {
            items(10) {
                //MostReadArticle()
                Spacer(modifier = Modifier.width(16.dp))

            }
        }

    }

}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .size(width = 150.dp, height = 150.dp)
            .background(harmonyHavenComponentWhite, shape = RoundedCornerShape(25.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true, radius = 75.dp)
            ) { /* Tıklama işlemi */ },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.harmony_haven_icon),
                contentDescription = null,
                Modifier.size(100.dp)

            )
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "Psychology",
                fontFamily = customFontInter,
                fontWeight = FontWeight.Medium,
                fontSize = MaterialTheme.typography.labelLarge.fontSize

            )
        }

    }

}

@Composable
fun ContentRow() {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Content()
            Content()
        }

    }


}


@Composable
fun ContentColumn(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Text(
            text = "Contents",
            modifier = Modifier
                .padding(start = 16.dp),
            fontFamily = customFontInter,
            fontWeight = FontWeight.Bold,
            color = harmonyHavenTitleTextColor,
            fontSize = MaterialTheme.typography.titleMedium.fontSize

        )
        repeat(10) {
            ContentRow()
        }

    }


}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MostReadHorizontalPager() {
    val pagerState = rememberPagerState(pageCount = {
        4//list size
    })

    val pages = listOf(
        MostReadArticleModel(
            "Embracing Life's Nuances",
            "Life is a journey filled with intricacies, where each moment presents us with new experiences. Along this path, we encounter a tapestry of joys and...",
            R.drawable.article_image//static data
        ),
        MostReadArticleModel(
            "Number2",
            "2Life is a journey filled with intricacies, where each moment presents us with new experiences. Along this path, we encounter a tapestry of joys and...",
            R.drawable.onboarding_screen_image_1//static data
        ),
        MostReadArticleModel(
            "Embracing Life's Nuances",
            "Life is a journey filled with intricacies, where each moment presents us with new experiences. Along this path, we encounter a tapestry of joys and...",
            R.drawable.onboarding_screen_image_3//static data
        ),
        MostReadArticleModel(
            "Embracing Life's Nuances",
            "Life is a journey filled with intricacies, where each moment presents us with new experiences. Along this path, we encounter a tapestry of joys and...",
            R.drawable.google_icon//static data
        )
    )



    Column(     

    ) {
        Text(
            text = "Recent Articles",
            modifier = Modifier
                .padding(start = 16.dp, bottom = 16.dp),
            fontFamily = customFontInter,
            fontWeight = FontWeight.Bold,
            color = harmonyHavenTitleTextColor,
            fontSize = MaterialTheme.typography.titleMedium.fontSize

        )
        Column(
            modifier = Modifier
                .size(width = 380.dp, height = 230.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HorizontalPager(
                modifier = Modifier
                    .size(width = 360.dp, height = 210.dp),
                state = pagerState,
                verticalAlignment = Alignment.Top,
            ) { page ->

                MostReadArticle(pages[page])


            }

            Row(

                horizontalArrangement = Arrangement.Center
            ) {

                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) harmonyHavenDarkGreenColor else harmonyHavenGradientWhite
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                    )
                }

            }


        }
    }
}

@Preview
@Composable
fun ExPrev() {
    MostReadHorizontalPager()
    
}