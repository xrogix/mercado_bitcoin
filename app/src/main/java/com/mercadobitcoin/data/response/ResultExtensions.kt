package com.mercadobitcoin.data.response

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

fun <T> Flow<T>.catchFailure(action: suspend kotlinx.coroutines.flow.FlowCollector<T>.(Failure) -> Unit): Flow<T> =
    catch {
        if(it is Failure){
            action(it)
        }else{
            action(Failure.GenericError())
        }
    }
