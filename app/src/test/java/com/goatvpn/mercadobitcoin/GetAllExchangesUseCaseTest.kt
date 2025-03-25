package com.goatvpn.mercadobitcoin

import com.mercadobitcoin.domain.entity.Exchange
import com.mercadobitcoin.domain.repository.ExchangeRepository
import com.mercadobitcoin.domain.usecase.GetAllExchangesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GetAllExchangesUseCaseTest {

    private lateinit var useCase: GetAllExchangesUseCase

    @MockK
    private lateinit var repository: ExchangeRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetAllExchangesUseCase(repository)
    }

    @Test
    fun `Test get all exchanges`() = runTest {
        val exchange = mockk<Flow<List<Exchange>>>()

        coEvery { useCase() } returns exchange

        val exchangeList = useCase()

        assertEquals(exchange, exchangeList)
    }

}
