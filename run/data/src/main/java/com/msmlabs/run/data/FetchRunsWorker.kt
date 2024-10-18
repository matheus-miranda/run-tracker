package com.msmlabs.run.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.msmlabs.core.domain.run.RunRepository
import com.msmlabs.core.domain.util.DataError

class FetchRunsWorker(
    appContext: Context,
    params: WorkerParameters,
    private val runRepository: RunRepository,
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {
        if (runAttemptCount >= 5) {
            return Result.failure()
        }

        return when (val result = runRepository.fetchRuns()) {
            is com.msmlabs.core.domain.util.Result.Error -> result.error.toWorkerResult()

            is com.msmlabs.core.domain.util.Result.Success -> Result.success()
        }
    }
}
