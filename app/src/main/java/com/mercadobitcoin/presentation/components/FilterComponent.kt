package com.mercadobitcoin.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mercadobitcoin.R
import com.mercadobitcoin.presentation.ui.theme.MercadoBitcoinTheme

@Composable
fun FilterComponent(
    modifier: Modifier = Modifier,
    onChange: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            text = it
            onChange(it)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = { Text(stringResource(R.string.search_placeholder)) }
    )
}

@Composable
@Preview
fun FilterComponentPreview() {
    MercadoBitcoinTheme {
        FilterComponent()
    }
}