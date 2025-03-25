package com.mercadobitcoin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mercadobitcoin.presentation.screens.listExchangeNavGraph

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.LIST_EXCHANGE) {
        listExchangeNavGraph()
    }
}