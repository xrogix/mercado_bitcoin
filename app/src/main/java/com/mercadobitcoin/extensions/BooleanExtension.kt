package com.mercadobitcoin.extensions

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}