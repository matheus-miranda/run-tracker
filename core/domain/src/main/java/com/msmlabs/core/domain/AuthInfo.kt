package com.msmlabs.core.domain

data class AuthInfo(
    val accessToken: String, // short-lived
    val refreshToken: String, // long-lived, used to refresh the access
    val userId: String,
)
