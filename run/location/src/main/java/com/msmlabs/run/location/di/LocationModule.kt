package com.msmlabs.run.location.di

import com.msmlabs.run.domain.LocationObserver
import com.msmlabs.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}
