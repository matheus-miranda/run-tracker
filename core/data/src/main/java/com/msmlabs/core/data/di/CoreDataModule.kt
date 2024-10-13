package com.msmlabs.core.data.di

import com.msmlabs.core.data.auth.EncryptedSessionStorage
import com.msmlabs.core.data.networking.HttpClientFactory
import com.msmlabs.core.data.run.OfflineFirstRunRepository
import com.msmlabs.core.domain.SessionStorage
import com.msmlabs.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}
