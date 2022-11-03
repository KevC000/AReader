package com.yonasoft.areader.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.firebase.auth.FirebaseAuth
import com.yonasoft.areader.components.FABContent
import com.yonasoft.areader.components.ReaderAppBar
import com.yonasoft.areader.components.TitleSection
import com.yonasoft.areader.model.MBook
import com.yonasoft.areader.navigation.ReaderScreens

@Preview
@Composable
fun Home(navController: NavController = NavController(LocalContext.current)) {
    Scaffold(
        topBar = { ReaderAppBar(title = "A. Reader", navController = navController) },
        floatingActionButton = {
            FABContent {

            }
        },

        ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeContent(navController)
        }
    }
}

@Composable
fun HomeContent(navController: NavController) {
    val email = FirebaseAuth.getInstance().currentUser?.email
    val currentUsername = if (!email.isNullOrEmpty())
        email.split("@").get(0) else "N/A"

    Column(
        Modifier.padding(2.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Row(modifier = Modifier.align(alignment = Alignment.Start)) {
            TitleSection(label = "Your reading \n" + "activity right now...")
            Spacer(modifier = Modifier.fillMaxWidth(0.7f))
            Column {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(ReaderScreens.ReaderStatsScreen.name)
                        }
                        .size(44.dp),
                    tint = MaterialTheme.colors.secondaryVariant
                )
                Text(
                    text = currentUsername,
                    modifier = Modifier.padding(2.dp),
                    color = Color.Red,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Divider()
            }
        }
    }
}


@Composable
fun ReadingRightNewArea(books: List<MBook>, navController: NavController) {

}

@Preview
@Composable
fun ListCard(
    book: MBook = MBook("asdf", "Running", "Me and you", "hello world"),
    onPressDetails: (String) -> Unit = {}
) {
    val context = LocalContext.current
    val resources = context.resources
    val displayMetrics = resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels / displayMetrics.density
    val spacing = 10.dp

    Card(
        shape = RoundedCornerShape(28.dp),
        backgroundColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier
            .padding(16.dp)
            .height(240.dp)
            .width(200.dp)
            .clickable { onPressDetails.invoke(book.title.toString()) }
    ) {
        Column(
            modifier = Modifier.width(screenWidth.dp - (spacing * 2)),
            horizontalAlignment = Alignment.Start
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = rememberImagePainter(data = ""),
                    contentDescription = "book image",
                    modifier = Modifier
                        .height(140.dp)
                        .width(100.dp)
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.width(48.dp))
            }
        }
    }

}



