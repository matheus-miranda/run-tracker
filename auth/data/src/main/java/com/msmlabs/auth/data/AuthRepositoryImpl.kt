package com.msmlabs.auth.data

import com.msmlabs.auth.domain.AuthRepository
import com.msmlabs.core.data.networking.post
import com.msmlabs.core.domain.util.DataError
import com.msmlabs.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
) : AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email, password
            )
        )
    }
}
