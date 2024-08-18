package com.msmlabs.auth.domain

import com.msmlabs.core.domain.util.DataError
import com.msmlabs.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
}
