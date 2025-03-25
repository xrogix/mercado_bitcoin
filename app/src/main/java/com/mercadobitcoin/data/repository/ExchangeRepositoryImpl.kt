package com.mercadobitcoin.data.repository

import com.mercadobitcoin.data.Api
import com.mercadobitcoin.data.mapper.toMap
import com.mercadobitcoin.data.response.toFlow
import com.mercadobitcoin.domain.entity.Exchange
import com.mercadobitcoin.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ExchangeRepositoryImpl(
    private val api: Api
): ExchangeRepository {

    override suspend fun getAllExchanges(): Flow<List<Exchange>> {
        return api.getAllExchanges().toFlow().map { it.toMap() }
    }

    override suspend fun getExchangeById(exchangeId: String): Flow<List<Exchange>> {
        return api.getExchangeById(exchangeId).toFlow().map { it.toMap() }
    }

}
