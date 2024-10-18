package com.msmlabs.run.data.di

import com.msmlabs.run.data.CreateRunWorker
import com.msmlabs.run.data.DeleteRunWorker
import com.msmlabs.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}
