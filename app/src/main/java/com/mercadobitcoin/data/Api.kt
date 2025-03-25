package com.mercadobitcoin.data

import com.mercadobitcoin.data.model.ExchangeResponse
import com.mercadobitcoin.data.response.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("v1/exchanges")
    suspend fun getAllExchanges(): NetworkResponse<List<ExchangeResponse>>

    @GET("v1/exchanges/{exchange_id}")
    suspend fun getExchangeById(
        @Path("exchange_id") exchangeId: String
    ): NetworkResponse<List<ExchangeResponse>>

}