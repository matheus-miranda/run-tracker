package com.msmlabs.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}
