package com.vicadev.solarsystemapp.ui.model

import android.graphics.Insets.add
import android.os.Build.VERSION.SDK_INT
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.Public
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.ComponentRegistry
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.OriginalSize
import coil.size.Size
import com.vicadev.solarsystemapp.R
import kotlinx.coroutines.launch
import java.nio.file.Files.size

@Composable
fun SolarSystemScreen(navigationController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = { MyToolbar(navigationController) },
        backgroundColor = colorResource(id = R.color.space),
        scaffoldState = scaffoldState,
        drawerContent = { MyDrawer() { coroutineScope.launch { scaffoldState.drawerState.close() } } },
        drawerGesturesEnabled = false
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Header()
            Body()
        }
    }
}



@Composable
fun MyToolbar(navigationController: NavHostController) {
    //Revisar las pestañas, no se ven, lo tapa toolbar
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Column(Modifier.padding(top = 120.dp)) {
        TabRow(
            selectedTabIndex = selectedIndex,
            contentColor = Color.Yellow,
            indicator = {}, backgroundColor = colorResource(id = R.color.space_toolbar)
        ) {
            LeadingIconTab(
                selected = selectedIndex == 0,
                text = {
                    Text(text = "Inicio", fontSize = 13.sp)
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White,
                onClick = { navigationController.navigate("solarSystem") })
            LeadingIconTab(selected = selectedIndex == 1, text = {
                Text(text = "Planetas", color = Color.White, fontSize = 13.sp)
            },
                icon =
                {
                    Icon(
                        imageVector = Icons.Rounded.Public,
                        contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp)
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White,
                onClick = { navigationController.navigate("planets") }
            )
            LeadingIconTab(selected = selectedIndex == 2, text = {
                Text(text = "Lunas", color = Color.White, fontSize = 13.sp)
            },
                icon =
                {
                    Icon(
                        imageVector = Icons.Rounded.Language,
                        contentDescription = null, tint = Color.White
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White,
                onClick = { navigationController.navigate("moons") })
        }
    }
    TopAppBar(
        modifier = Modifier.height(120.dp),
        contentPadding = PaddingValues(all = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.system),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = CenterVertically
            ) {
                Text(text = "Sistema Solar", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            }
        }
    }

}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "First Option", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Second Option", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(text = "Cerrar menú", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() })
    }
}

@Composable
fun Body(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Box(modifier = Modifier.fillMaxSize()) {

        Column(Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(context).data(data = R.drawable.gif_solar_system)
                        .apply(block = {
                            size(Size.ORIGINAL)
                        }).build(), imageLoader = imageLoader
                ),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .size(350.dp),
            )

            Text(
                text = stringResource(id = R.string.initial_text),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

    }

}