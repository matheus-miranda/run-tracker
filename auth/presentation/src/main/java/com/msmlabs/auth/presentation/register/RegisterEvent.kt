package com.msmlabs.auth.presentation.register

import com.msmlabs.core.presentation.ui.UiText

/**
 * Events are one time responses from the Model to the UI
 */
sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent
    data class Error(val error: UiText) : RegisterEvent
}
