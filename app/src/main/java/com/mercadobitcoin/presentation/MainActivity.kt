package com.mercadobitcoin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.mercadobitcoin.navigation.NavigationGraph
import com.mercadobitcoin.presentation.ui.theme.MercadoBitcoinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MercadoBitcoinApp()
        }
    }
}

@Composable
fun MercadoBitcoinApp() {
    MercadoBitcoinTheme {
        val navController = rememberNavController()
        NavigationGraph(navController)
    }
}