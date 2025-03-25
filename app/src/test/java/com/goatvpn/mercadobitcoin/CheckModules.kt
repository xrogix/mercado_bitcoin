package com.goatvpn.mercadobitcoin


import com.mercadobitcoin.di.appModule
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class CheckModules: KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkModules() {
        appModule.verify()
    }

}
