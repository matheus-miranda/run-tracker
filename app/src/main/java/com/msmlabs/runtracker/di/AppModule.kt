package com.msmlabs.runtracker.di

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.msmlabs.runtracker.MainViewModel
import com.msmlabs.runtracker.RuntrackerApp
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<SharedPreferences> {
        EncryptedSharedPreferences(
            context = androidApplication(),
            fileName = "auth_pref",
            masterKey = MasterKey(androidApplication()),
            prefKeyEncryptionScheme = EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            prefValueEncryptionScheme = EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
    single<CoroutineScope> { (androidApplication() as RuntrackerApp).applicationScope }

    viewModelOf(::MainViewModel)
}
