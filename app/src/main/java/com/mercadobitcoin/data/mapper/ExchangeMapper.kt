package com.mercadobitcoin.data.mapper

import com.mercadobitcoin.data.model.ExchangeResponse
import com.mercadobitcoin.data.model.IconResponse
import com.mercadobitcoin.domain.entity.Exchange
import com.mercadobitcoin.domain.entity.Icon

@JvmName("toExchangeMap")
fun List<ExchangeResponse>.toMap(): List<Exchange> {
    return this.map {
        Exchange(
            it.exchangeId,
            it.website,
            it.name,
            it.dataStart,
            it.dataEnd,
            it.dataQuoteStart,
            it.dataQuoteEnd,
            it.dataOrderBookStart,
            it.dataOrderBookEnd,
            it.dataTradeStart,
            it.dataTradeEnd,
            it.dataTradeCount,
            it.dataSymbolsCount,
            it.volumeOneHourUsd,
            it.volumeOneDayUsd,
            it.volumeOneMonthUsd,
            it.metricId ?: emptyList(),
            it.icons?.toMap() ?: emptyList()
        )
    }
}

@JvmName("toIconMap")
fun List<IconResponse>.toMap(): List<Icon> {
    return this.map {
        Icon(
            it.exchangeId,
            it.assetId,
            it.url
        )
    }
}