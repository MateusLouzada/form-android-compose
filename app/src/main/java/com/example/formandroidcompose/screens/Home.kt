package com.example.formandroidcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.formandroidcompose.R
import com.example.formandroidcompose.ui.theme.Purple40

@Composable
fun Home() {
    Surface(
        color = Color.White, modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            ) {
                Box {
                    Row {
                        ImageFromAsset(resourceId = R.drawable.user_photo)
                        Column {
                            Text(text = "Bem vindo!")
                            Text(text = "Lucas")
                        }
                    }
                }
                Box {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                }
            }
            SearchInput(onSearch = { query ->
                // Handle the search query
                // You can perform search-related actions here
                println("Pesquisa: $query")
            })
        }
    }
}

@Composable
fun SearchInput(onSearch: (String) -> Unit) {
    var query by remember { mutableStateOf("") }

    BasicTextField(
        value = query,
        onValueChange = { query = it },
        textStyle = LocalTextStyle.current.copy(color = Color.Green),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFEDEDED))
            .height(56.dp)
            .clip(RoundedCornerShape(50.dp)),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(query)
            }
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = query,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ImageFromAsset(resourceId: Int) {
    val painter: Painter = painterResource(id = resourceId)

    Box {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp, 50.dp)
                .background(MaterialTheme.colorScheme.background)
        )
    }
}