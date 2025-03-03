package com.example.mangaflow.feature.common

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mangaflow.core.design_system.icons.MangaFlowIcons
import com.example.mangaflow.feature.bookmarks_screen.navigation.BookmarksScreenRoute
import com.example.mangaflow.feature.home_screen.navigation.HomeScreenRoute
import com.example.mangaflow.feature.profile_screen.navigation.ProfileScreenRoute
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavBar(
    navController: NavController
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    val currentRoute = if(currentDestination != null) currentDestination.toString().split(".")[6] else "HomeScreenRoute"

    NavigationBar {
        navItems.forEach { navItem ->
            val chosen = currentRoute == navItem.route

            NavigationBarItem(
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