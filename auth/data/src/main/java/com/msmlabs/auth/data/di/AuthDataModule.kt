package com.msmlabs.auth.data.di

import com.msmlabs.auth.data.AuthRepositoryImpl
import com.msmlabs.auth.data.EmailPatternValidator
import com.msmlabs.auth.domain.AuthRepository
import com.msmlabs.auth.domain.PatternValidator
import com.msmlabs.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> { EmailPatternValidator }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}
