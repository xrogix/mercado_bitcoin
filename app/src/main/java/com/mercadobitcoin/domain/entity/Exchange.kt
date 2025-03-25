package com.mercadobitcoin.domain.entity

data class Exchange(
    val exchangeId: String?,
    val website: String?,
    val name: String?,
    val dataStart: String?,
    val dataEnd: String?,
    val dataQuoteStart: String?,
    val dataQuoteEnd: String?,
    val dataOrderBookStart: String?,
    val dataOrderBookEnd: String?,
    val dataTradeStart: String?,
    val dataTradeEnd: String?,
    val dataTradeCount: Int?,
    val dataSymbolsCount: Int?,
    val volumeOneHourUsd: Double?,
    val volumeOneDayUsd: Double?,
    val volumeOneMonthUsd: Double?,
    val metricId: List<String>?,
    val icons: List<Icon>?
)
