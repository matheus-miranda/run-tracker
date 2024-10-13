package com.msmlabs.run.network.di

import com.msmlabs.core.domain.run.RemoteRunDataSource
import com.msmlabs.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}
