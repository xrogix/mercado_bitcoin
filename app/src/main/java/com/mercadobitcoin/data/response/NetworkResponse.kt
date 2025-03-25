package com.mercadobitcoin.data.response

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

sealed class NetworkResponse<out T> {
    data class Success<out T>(
        val value: T
    ) : NetworkResponse<T>()

    data class Error(
        val body: Any? = null,
        @Transient
        val exception: Failure? = null
    ) : NetworkResponse<Nothing>()
}

fun <T> NetworkResponse<T>.toFlow(): Flow<T> {
    val networkResponse = this
    return flow {
        when (networkResponse) {
            is NetworkResponse.Success -> {
                emit(networkResponse.value)
            }
            is NetworkResponse.Error -> {
                throw networkResponse.exception ?: Failure.GenericError()
            }
        }
    }
}
