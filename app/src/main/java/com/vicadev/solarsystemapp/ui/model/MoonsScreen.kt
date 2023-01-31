package com.vicadev.solarsystemapp.ui.model

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.DoubleArrow
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.vicadev.solarsystemapp.R
import com.vicadev.solarsystemapp.data.ItemsCelestials
import com.vicadev.solarsystemapp.data.ListMoons
import com.vicadev.solarsystemapp.data.ListObjects
import kotlinx.coroutines.launch

@Composable
fun MoonsScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = { MyToolbar(navController) },
        backgroundColor = colorResource(id = R.color.space),
        scaffoldState = scaffoldState,
        drawerContent = { MyDrawer() { coroutineScope.launch { scaffoldState.drawerState.close() } } },
        drawerGesturesEnabled = false
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.space)),
        ) {
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center
            ) {
                items(ListMoons()) { items: ItemsCelestials ->
                    Moons(myObjects = items) {}
                }
            }
        }
    }

}

@Composable
fun Moons(myObjects: ItemsCelestials, onItemSelected: (ItemsCelestials) -> Unit) {
    var isVisible by rememberSaveable() {
        mutableStateOf(false)
    }
    var show by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(150.dp)
            .padding(8.dp)
            .clickable { onItemSelected(myObjects) },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.space_toolbar)),
            Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = myObjects.img), contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clickable { isVisible = !isVisible }
                    .background(Color.Black))

            AnimatedVisibility(visible = isVisible) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .align(CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = myObjects.title),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = Color.White,
                        fontSize = 24.sp
                    )
                    IconButton(onClick = { show = true }) {
                        Icon(
                            imageVector = Icons.Rounded.DoubleArrow,
                            contentDescription = null,
                            tint = Color.White
                        )
                        MyAlertMoonsDialog(
                            myObjects = myObjects,
                            show = show,
                            onDismiss = { show = false }) {

                        }
                    }
                }
            }

        }
    }
}

@Composable
fun MyAlertMoonsDialog(
    myObjects: ItemsCelestials,
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {

        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(id = R.color.space))
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                MyTitleMoonsDialog(myObjects = myObjects, onDismiss = { onDismiss() })
                Divider(
                    Modifier
                        .border(1.dp, color = Color.Gray)
                        .fillMaxWidth()
                )
                MyDescriptionMoonsDialog(myObjects = myObjects)
            }
        }
    }
}

@Composable
fun MyTitleMoonsDialog(myObjects: ItemsCelestials, onDismiss: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = stringResource(id = myObjects.title),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Icon(
            imageVector = Icons.Rounded.Close,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.clickable { onDismiss() })
    }

}

@Composable
fun MyDescriptionMoonsDialog(myObjects: ItemsCelestials) {
    Text(
        text = stringResource(id = myObjects.description),
        fontSize = 16.sp,
        color = Color.White,
        modifier = Modifier.padding(top = 10.dp)
    )
}





























