package com.mercadobitcoin.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mercadobitcoin.R
import com.mercadobitcoin.presentation.components.ExchangeDetailComponent
import com.mercadobitcoin.presentation.components.ExchangeItemComponent
import com.mercadobitcoin.presentation.components.FilterComponent
import com.mercadobitcoin.presentation.components.TitleComponent

@Composable
fun ListExchangeScreen(
    uiState: ListExchangeUIState,
    filter: (String) -> Unit,
    selectExchange: (String) -> Unit,
    dissmiss: () -> Unit
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Column {
                TitleComponent(
                    title = stringResource(R.string.exchange_title),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.padding(8.dp))

                FilterComponent(
                    modifier = Modifier.fillMaxWidth(),
                ) { query ->
                    filter(query)
                }

                Spacer(modifier = Modifier.padding(8.dp))

                if(uiState.isLoading) {
                    Box(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(
                                Alignment.Center
                            )
                        )
                    }
                } else {
                    LazyColumn {
                        items(uiState.exchanges) { exchange ->
                            ExchangeItemComponent(
                                exchange = exchange
                            ) { exchange ->
                                selectExchange(exchange.exchangeId.orEmpty())
                            }
                            Spacer(modifier = Modifier.padding(8.dp))
                        }
                    }

                    if(uiState.showBottomSheet) {
                        uiState.selectedExchange?.let { exchange ->
                            ExchangeDetailComponent(
                                exchange = exchange
                            ) {
                                dissmiss()
                            }
                        }
                    }

                }
            }
        }
    }
}