package com.msmlabs.auth.data

import android.util.Patterns
import com.msmlabs.auth.domain.PatternValidator

object EmailPatternValidator : PatternValidator {
    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}
