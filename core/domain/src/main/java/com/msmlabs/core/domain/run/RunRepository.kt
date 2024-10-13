package com.msmlabs.core.domain.run

import com.msmlabs.core.domain.util.DataError
import com.msmlabs.core.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow

interface RunRepository {
    fun getRuns(): Flow<List<Run>>
    suspend fun fetchRuns(): EmptyResult<DataError>
    suspend fun upsertRuns(run: Run, mapPicture: ByteArray): EmptyResult<DataError>
    suspend fun deleteRun(id: RunId)
}
