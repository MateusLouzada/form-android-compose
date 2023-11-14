package com.example.formandroidcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import com.example.formandroidcompose.R
import com.example.formandroidcompose.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {
    var text by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isUsernameFocused by remember { mutableStateOf(false) }
    var isPasswordFocused by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Tipo de usuário") }
    var textClicked by remember { mutableStateOf(false) }

    val textClick = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White
            )
        ) {
            append("Esqueceu a sua senha? Clique aqui!")
        }

        addStringAnnotation(
            tag = "clicked",
            annotation = "Clicked",
            start = 0,
            end = length
        )
    }

    @Composable
    fun ImageFromAsset(resourceId: Int) {
        val painter: Painter = painterResource(id = resourceId)

        Box(
            modifier = Modifier
                .padding(bottom = 100.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp, 100.dp)
            )
        }
    }

    Surface(
        color = Purple40, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            ImageFromAsset(R.drawable.logosvg)

            TextField(value = text,
                onValueChange = { text = it },
                label = {
                    if (!isUsernameFocused) {
                        Text("Telefone, CPF, RG...", color = Purple40)
                    } else {
                        Text("Login", color = Purple40)
                    }

                },
                maxLines = 2,
                textStyle = TextStyle(color = Purple40, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(20.dp)
                    .onFocusChanged { focusState ->
                        isUsernameFocused = focusState.isFocused
                    }
                    .background(color = Color.Transparent)
                    .clip(MaterialTheme.shapes.small))

            TextField(value = password,
                onValueChange = { password = it },
                label = {
                    if (!isPasswordFocused) {
                        Text("******", color = Purple40)
                    } else {
                        Text("Senha", color = Purple40)
                    }
                },
                placeholder = { Text(text = "Telefone") },
                trailingIcon = {
                    IconButton(onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }) {
                        Icon(
                            if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (isPasswordVisible) "Hide Password" else "Show Password"
                        )
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .padding(20.dp)
                    .onFocusChanged { focusState ->
                        isPasswordFocused = focusState.isFocused
                    }
                    .background(color = Color.Transparent)
                    .clip(MaterialTheme.shapes.small))

            Column(Modifier.padding(20.dp)) {

                // Create an Outlined Text Field
                // with icon and not expanded
//                OutlinedTextField(
//                    value = mSelectedText,
//                    onValueChange = { mSelectedText = it },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .onGloballyPositioned { coordinates ->
//                            // This value is used to assign to
//                            // the DropDown the same width
//                            mTextFieldSize = coordinates.size.toSize()
//                        },
//                    label = {Text("Label")},
//                    trailingIcon = {
//                        Icon(icon,"contentDescription",
//                            Modifier.clickable { mExpanded = !mExpanded })
//                    }
//                )

                // Create a drop-down menu with list of cities,
                // when clicked, set the Text Field text as the city selected
//                DropdownMenu(
//                    expanded = mExpanded,
//                    onDismissRequest = { mExpanded = false },
//                    modifier = Modifier
//                        .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
//                ) {
//                    mCities.forEach { label ->
//                        DropdownMenuItem(onClick = {
//                            mSelectedText = label
//                            mExpanded = false
//                        }) {
//                            Text(text = label)
//                        }
//                    }
//                }
//            }
                ClickableText(
                    text = textClick,
                    modifier = Modifier.clickable {
                        textClicked = !textClicked
                    },
                    onClick = { offset ->
                        val annotations = textClick.getStringAnnotations("Clicked", offset, offset)

                        if (annotations.isNotEmpty()) {
                            textClicked = !textClicked
                        }
                    }
                )
            }
        }
    }
}


@Composable
@Preview
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}