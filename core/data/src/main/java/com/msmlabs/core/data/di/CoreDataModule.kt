package com.msmlabs.core.data.di

import com.msmlabs.core.data.auth.EncryptedSessionStorage
import com.msmlabs.core.data.networking.HttpClientFactory
import com.msmlabs.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}
