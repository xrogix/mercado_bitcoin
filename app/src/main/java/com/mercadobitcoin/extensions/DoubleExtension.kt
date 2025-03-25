package com.mercadobitcoin.extensions

import java.text.NumberFormat
import java.util.Locale

fun Double?.formatToDollar(): String {
    return this?.let {
//        val value = it.toString()
//        val decimal = value.substringAfter(".")
//        val integer = value.substringBefore(".")
//        val formattedInteger = integer.reversed().chunked(3).joinToString(",").reversed()
//        "$$formattedInteger.$decimal"
        val format = NumberFormat.getCurrencyInstance(Locale.US)
        format.format(this)
    } ?: "$0.00"
}