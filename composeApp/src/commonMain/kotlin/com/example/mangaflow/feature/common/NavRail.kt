package com.example.mangaflow.feature.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mangaflow.core.design_system.theme.mColors
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavRail(
    navController: NavController
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    val currentRoute = if(currentDestination != null) currentDestination.toString().split(".")[6] else "HomeScreenRoute"

    NavigationRail(
        containerColor = mColors.surfaceContainer
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxHeight(),
        ) {
            navItems.forEach { navItem ->
                val chosen = currentRoute == navItem.route

                NavigationRailItem(
                    selected = currentRoute == navItem.route,
                    onClick = {
                        if(!chosen) {
                            navController.navigate(navItem.destination)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(if(chosen) navItem.iconChosen else navItem.iconDefault),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(navItem.label)
                    }
                )
            }
        }
    }
}