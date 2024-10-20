package com.msmlabs.run.data.di

import com.msmlabs.core.domain.run.SyncRunScheduler
import com.msmlabs.run.data.CreateRunWorker
import com.msmlabs.run.data.DeleteRunWorker
import com.msmlabs.run.data.FetchRunsWorker
import com.msmlabs.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}
