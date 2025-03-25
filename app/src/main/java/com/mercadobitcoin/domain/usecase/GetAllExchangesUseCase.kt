package com.mercadobitcoin.domain.usecase

import com.mercadobitcoin.domain.entity.Exchange
import com.mercadobitcoin.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow

class GetAllExchangesUseCase(
    private val repository: ExchangeRepository
) {

    suspend operator fun invoke(): Flow<List<Exchange>> = repository.getAllExchanges()

}
