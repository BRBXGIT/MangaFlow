package com.example.mangaflow.feature.auth_screen.sections.large_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mangaflow.core.design_system.custom_modifiers.noRippleClickable
import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import com.example.mangaflow.core.design_system.theme.mColors
import com.example.mangaflow.core.design_system.theme.mShapes
import com.example.mangaflow.core.design_system.theme.mTypography
import org.jetbrains.compose.resources.painterResource

@Composable
fun AuthBlockLargeScreensSection(
    onAuthenticateClick: (userName: String, password: String) -> Unit
) {
    Column {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.3f)
                .background(
                    color = mColors.surfaceContainerHigh,
                    shape = RoundedCornerShape(
                        topEnd = 8.dp,
                        topStart = 8.dp
                    )
                )
                .padding(24.dp)

        ) {
            Text(
                text = "Sign in to your account",
                style = mTypography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            var username by rememberSaveable { mutableStateOf("") }
            TextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Username") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(MangaFlowIcons.User),
                        contentDescription = null
                    )
                }
            )

            var password by rememberSaveable { mutableStateOf("") }
            var showPassword by rememberSaveable { mutableStateOf(false) }
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Password") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(MangaFlowIcons.Password),
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { showPassword = !showPassword }
                    ) {
                        Icon(
                            painter = painterResource(
                                if(showPassword) MangaFlowIcons.Eye else MangaFlowIcons.EyeClosed
                            ),
                            contentDescription = null
                        )
                    }
                },
                visualTransformation = if(!showPassword) VisualTransformation.None else PasswordVisualTransformation()
            )

            Button(
                shape = mShapes.small,
                onClick = {
                    onAuthenticateClick(username, password)
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Sign in")
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.3f)
                .background(
                    color = mColors.surfaceContainerHighest,
                    shape = RoundedCornerShape(
                        bottomEnd = 8.dp,
                        bottomStart = 8.dp
                    )
                )
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Text(
                    text = "New user? ",
                    style = mTypography.labelLarge
                )

                Text(
                    text = "Register",
                    style = mTypography.labelLarge.copy(
                        color = mColors.primary,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .clip(mShapes.small)
                        .noRippleClickable {  }
                )
            }
        }
    }
}