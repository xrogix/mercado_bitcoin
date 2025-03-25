package com.mercadobitcoin.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mercadobitcoin.R
import com.mercadobitcoin.domain.entity.Exchange
import com.mercadobitcoin.extensions.formatToDollar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeDetailComponent(
    exchange: Exchange,
    onDissmiss: () -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        sheetState = bottomSheetState,
        onDismissRequest = { onDissmiss() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TitleComponent(title = exchange.name.orEmpty())

            Spacer(modifier = Modifier.padding(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.volume_hour),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = exchange.volumeOneHourUsd.formatToDollar()
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.volume_day),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = exchange.volumeOneDayUsd.formatToDollar()
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.volume_month),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = exchange.volumeOneMonthUsd.formatToDollar()
                )
            }
        }
    }
}