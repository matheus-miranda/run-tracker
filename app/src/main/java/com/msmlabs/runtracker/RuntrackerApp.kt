package com.msmlabs.runtracker

import android.app.Application
import com.msmlabs.auth.data.di.authDataModule
import com.msmlabs.auth.presentation.di.authViewModelModule
import com.msmlabs.core.data.di.coreDataModule
import com.msmlabs.core.database.di.databaseModule
import com.msmlabs.run.location.di.locationModule
import com.msmlabs.run.presentation.di.runPresentationModule
import com.msmlabs.runtracker.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuntrackerApp : Application() {

    // For independent coroutines even in failure of others
    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@RuntrackerApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
            )
        }
    }
}
