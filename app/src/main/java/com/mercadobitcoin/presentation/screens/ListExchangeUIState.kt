package com.mercadobitcoin.presentation.screens

import com.mercadobitcoin.data.response.Failure
import com.mercadobitcoin.domain.entity.Exchange

data class ListExchangeUIState(
    val exchanges: List<Exchange> = emptyList(),
    val originalExchanges: List<Exchange> = emptyList(),
    val isLoading: Boolean = false,
    val error: Failure?,
    val showBottomSheet: Boolean = false,
    val selectedExchange: Exchange? = null
)
