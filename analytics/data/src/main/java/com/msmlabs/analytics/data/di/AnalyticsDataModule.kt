package com.msmlabs.analytics.data.di

import com.msmlabs.analytics.data.RoomAnalyticsRepository
import com.msmlabs.analytics.domain.AnalyticsRepository
import com.msmlabs.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}
