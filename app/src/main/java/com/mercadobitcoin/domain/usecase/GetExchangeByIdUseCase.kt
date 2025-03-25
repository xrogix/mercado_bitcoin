package com.mercadobitcoin.domain.usecase

import com.mercadobitcoin.domain.entity.Exchange
import com.mercadobitcoin.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow

class GetExchangeByIdUseCase(
    private val repository: ExchangeRepository
) {

    suspend operator fun invoke(exchangeId: String): Flow<List<Exchange>> =
        repository.getExchangeById(exchangeId)

}
