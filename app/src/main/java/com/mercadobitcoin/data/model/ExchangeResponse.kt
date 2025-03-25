package com.mercadobitcoin.data.model

import com.squareup.moshi.Json

data class ExchangeResponse(
    @Json(name = "exchange_id")
    val exchangeId: String?,
    @Json(name = "website")
    val website: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "data_start")
    val dataStart: String?,
    @Json(name = "data_end")
    val dataEnd: String?,
    @Json(name = "data_quote_start")
    val dataQuoteStart: String?,
    @Json(name = "data_quote_end")
    val dataQuoteEnd: String?,
    @Json(name = "data_orderbook_start")
    val dataOrderBookStart: String?,
    @Json(name = "data_orderbook_end")
    val dataOrderBookEnd: String?,
    @Json(name = "data_trade_start")
    val dataTradeStart: String?,
    @Json(name = "data_trade_end")
    val dataTradeEnd: String?,
    @Json(name = "data_trade_count")
    val dataTradeCount: Int?,
    @Json(name = "data_symbols_count")
    val dataSymbolsCount: Int?,
    @Json(name = "volume_1hrs_usd")
    val volumeOneHourUsd: Double?,
    @Json(name = "volume_1day_usd")
    val volumeOneDayUsd: Double?,
    @Json(name = "volume_1mth_usd")
    val volumeOneMonthUsd: Double?,
    @Json(name = "metric_id")
    val metricId: List<String>?,
    @Json(name = "icons")
    val icons: List<IconResponse>?
)
