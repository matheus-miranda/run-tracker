package com.msmlabs.auth.data

import com.msmlabs.auth.domain.AuthRepository
import com.msmlabs.core.data.networking.post
import com.msmlabs.core.domain.AuthInfo
import com.msmlabs.core.domain.SessionStorage
import com.msmlabs.core.domain.util.DataError
import com.msmlabs.core.domain.util.EmptyResult
import com.msmlabs.core.domain.util.Result
import com.msmlabs.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage,
) : AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email, password
            )
        )
    }

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(email, password)
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }
}
