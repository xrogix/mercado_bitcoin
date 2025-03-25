package com.mercadobitcoin.presentation.screens

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mercadobitcoin.navigation.Routes
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.listExchangeNavGraph() {
    composable(Routes.LIST_EXCHANGE) {

        val viewModel = koinViewModel<ListExchangeViewModel>()
        val uiState by viewModel.uiState.collectAsState()

        ListExchangeScreen(
            uiState = uiState,
            filter = { query ->
                viewModel.filter(query)
            },
            selectExchange = {
                viewModel.selectExchange(it)
            },
            dissmiss = {
                viewModel.closeBottomSheet()
            }
        )
    }
}