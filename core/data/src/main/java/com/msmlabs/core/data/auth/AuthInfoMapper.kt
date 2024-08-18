package com.msmlabs.core.data.auth

import com.msmlabs.core.domain.AuthInfo

fun AuthInfo.toAuthInfoSerializable() = AuthInfoSerializable(
    accessToken, refreshToken, userId
)

fun AuthInfoSerializable.toAuthInfo() = AuthInfo(
    accessToken, refreshToken, userId
)
