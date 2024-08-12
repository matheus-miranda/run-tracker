package com.msmlabs.core.data.networking.di

import com.msmlabs.core.data.networking.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}
