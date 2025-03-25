package com.mercadobitcoin.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadobitcoin.data.response.Failure
import com.mercadobitcoin.data.response.catchFailure
import com.mercadobitcoin.domain.usecase.GetAllExchangesUseCase
import com.mercadobitcoin.domain.usecase.GetExchangeByIdUseCase
import com.mercadobitcoin.extensions.orFalse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListExchangeViewModel(
    private val getAllExchangesUseCase: GetAllExchangesUseCase,
    private val getExchangeByIdUseCase: GetExchangeByIdUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(
        ListExchangeUIState(
            exchanges = emptyList(),
            originalExchanges = emptyList(),
            isLoading = true,
            error = null
        )
    )
    val uiState = _uiState
        .onStart { getAll() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = _uiState.value
        )

    private fun getAll() = viewModelScope.launch {
        getAllExchangesUseCase()
            .onStart {
                loading()
            }
            .onCompletion {
                loaded()
            }
            .catchFailure { error -> handleError(error) }
            .collect { exchanges ->
                _uiState.value = _uiState.value.copy(
                    exchanges = exchanges,
                    originalExchanges = exchanges,
                )
            }
    }

    private fun loading() {
        _uiState.update { it.copy(isLoading = true) }
    }

    private fun loaded() {
        _uiState.update { it.copy(isLoading = false) }
    }

    private fun handleError(error: Failure) {
        _uiState.update { it.copy(error = error) }
    }

    fun filter(query: String) {
        _uiState.update {
            val filteredExchanges = it.originalExchanges.filter { exchange ->
                exchange.name?.contains(query, ignoreCase = true).orFalse()
            }
            it.copy(exchanges = filteredExchanges)
        }
    }

    fun selectExchange(exchange: String) = viewModelScope.launch {
        getExchangeByIdUseCase(exchange)
            .catchFailure { error -> handleError(error) }
            .collect { exchange ->
                _uiState.update {
                    it.copy(
                        selectedExchange = exchange.first(),
                        showBottomSheet = true
                    )
                }
            }
    }

    fun closeBottomSheet() {
        _uiState.update {
            it.copy(
                showBottomSheet = false
            )
        }
    }

}