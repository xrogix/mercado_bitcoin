package com.mercadobitcoin.data.model

import com.squareup.moshi.Json

data class IconResponse(
    @Json(name = "exchange_id")
    val exchangeId: String?,
    @Json(name = "asset_id")
    val assetId: String?,
    @Json(name = "url")
    val url: String
)
