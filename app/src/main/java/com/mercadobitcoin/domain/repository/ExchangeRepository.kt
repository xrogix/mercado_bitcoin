package com.mercadobitcoin.domain.repository

import com.mercadobitcoin.domain.entity.Exchange
import kotlinx.coroutines.flow.Flow

interface ExchangeRepository {
    suspend fun getAllExchanges(): Flow<List<Exchange>>

    suspend fun getExchangeById(exchangeId: String): Flow<List<Exchange>>
}